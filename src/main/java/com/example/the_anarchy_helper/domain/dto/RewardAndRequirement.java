package com.example.the_anarchy_helper.domain.dto;

import com.example.the_anarchy_helper.domain.entity.Requirement;
import com.example.the_anarchy_helper.domain.entity.RewardAction;
import com.example.the_anarchy_helper.domain.entity.RewardActionRequirement;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RewardAndRequirement {
    private RewardAction rewardAction;
    private Requirement requirement;

    public static RewardAndRequirement buildRewardAndRequirement(RewardActionRequirement rewardActionRequirement){
        return RewardAndRequirement.builder()
                .requirement(rewardActionRequirement.getRequirement())
                .rewardAction(rewardActionRequirement.getRewardAction())
                .build();
    }
}
