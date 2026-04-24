package com.example.the_anarchy_helper.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ResourceType {
    @NotBlank(message = "needed resource name cannot be null or empty")
    private String name;
    private Integer quantity;

}
