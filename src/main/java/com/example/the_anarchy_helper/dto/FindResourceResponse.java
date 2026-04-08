package com.example.the_anarchy_helper.dto;

import lombok.Data;

import java.util.List;

@Data
public class FindResourceResponse {
    List<Actions> actionsForReward;
}
