package com.example.the_anarchy_helper.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Actions {
    private String name;
    private String area;
    private List<String> prerequisite;
    private List<String> costs;
//    private List<Attributes> rewards;
}
