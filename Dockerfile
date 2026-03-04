# ============================================================
# STAGE 1: BUILD
# We use a full JDK image to compile the project with Maven
# ============================================================
FROM eclipse-temurin:21-jdk-jammy AS builder

WORKDIR /build

# Copy Maven wrapper files first (used to run Maven without installing it globally)
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Give execution permission to Maven wrapper script
RUN chmod +x mvnw

# Download all dependencies defined in pom.xml WITHOUT compiling the source yet.
# This is a Docker cache optimization: if pom.xml doesn't change,
# Docker reuses this layer and skips re-downloading dependencies.
RUN ./mvnw -q -DskipTests dependency:go-offline

# Now copy the actual source code
COPY src ./src

# Compile and package the app into a .jar (skip tests for speed)
RUN ./mvnw clean package -DskipTests

# ============================================================
# STAGE 2: RUNTIME
# We use a smaller JRE-only image to run the compiled .jar
# This makes the final image much lighter (no compiler tools)
# ============================================================
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# Create a non-root user for security best practices
# Running as root inside a container is a security risk
RUN groupadd -r spring && useradd -r -g spring spring

# Copy ONLY the compiled .jar from the builder stage
# We don't copy source code or Maven tools — keeps the image clean
COPY --from=builder /build/target/*.jar app.jar

# Give ownership of the jar to our non-root user
RUN chown spring:spring app.jar

# Switch to non-root user
USER spring:spring

# Tell Docker which port this app listens on (documentation only — doesn't open ports by itself)
EXPOSE 8080

# JAVA_OPTS allows you to pass JVM flags via environment variables (e.g., memory limits)
ENV JAVA_OPTS=""

# Start the Spring Boot app
# Using "sh -c" so that $JAVA_OPTS gets evaluated as a shell variable
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]