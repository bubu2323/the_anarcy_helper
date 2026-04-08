package com.example.the_anarchy_helper.dto;

import jakarta.annotation.Nullable;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class FindResourceRequest {
    @NonNull
    private ResourceType neededResourceType;
    @Nullable
    private List<ResourceType> ownedResourceType;
    @NonNull
    private Necessity necessity;
}
