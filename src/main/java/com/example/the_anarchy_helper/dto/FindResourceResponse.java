package com.example.the_anarchy_helper.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class FindResourceResponse {

    private Map<ResourceType, Actions> resourceTypeActionsMap = new HashMap<>();

    private Map<ResourceType, Actions> resourceTypeActionsMapBuilder(ResourceType resource, Actions action) {
        return Map.of(resource, action);
    }
}
