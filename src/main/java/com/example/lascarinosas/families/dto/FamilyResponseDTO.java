package com.example.lascarinosas.families.dto;

import java.util.List;

public record FamilyResponseDTO(String name,
                                List<String> membersName) {
}
