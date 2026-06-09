package com.example.the_anarchy_helper.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceType {
    @NotBlank(message = "needed resource name cannot be null or empty")
    private String name;
    private Integer quantity;

}
