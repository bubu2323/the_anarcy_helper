package com.example.the_anarchy_helper.repository;

import com.example.the_anarchy_helper.entity.RewardActionRequirement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RewardActionsRequirementsRepository extends JpaRepository<RewardActionRequirement, Integer> {
    List<RewardActionRequirement> findByRequirementId(Integer requirementId);

    List<RewardActionRequirement> findByRewardActionId(Integer rewardActionId);
}
