package com.example.the_anarchy_helper.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class FindResourceResponse {
    List<Actions> actionsForReward = new ArrayList<>();

    public static FindResourceResponse createFindResourceResponse(List<Actions> actionsList){
        return new FindResourceResponse(actionsList);
    }
}
