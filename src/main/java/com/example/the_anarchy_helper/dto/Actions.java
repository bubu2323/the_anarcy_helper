package com.example.the_anarchy_helper.dto;

import lombok.Data;

import java.util.List;

@Data
public class Actions {
    private String name; //move to enum
    private Area area;
    private String prerequisite;
    private List<ResourceType> costs;
    private List<Attributes> rewards;
}
