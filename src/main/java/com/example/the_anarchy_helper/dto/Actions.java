package com.example.the_anarchy_helper.dto;

import lombok.Data;

import java.util.List;

@Data
public class Actions {
    private String name;
    private String actionCategory; //move to enum buy, build, owerhelm, score, fill, use, gain
    private Area area;
    private List<String> prerequisite;
    private List<ResourceType> costs;
    private List<Attributes> rewards;
}
