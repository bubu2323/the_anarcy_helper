package com.example.the_anarchy_helper.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class FindResourceRequest {
    @NotNull(message = "neededResourceType cannot be null")
    @Valid
    private ResourceType neededResourceType;
    @Nullable
    @Valid
    private List<ResourceType> ownedResourceType;
    @NotNull(message = "necessity of a resource cannot be null")
    private Necessity necessity;
}
