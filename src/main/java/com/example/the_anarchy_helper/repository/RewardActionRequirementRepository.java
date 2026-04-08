package com.example.the_anarchy_helper.repository;

import com.example.the_anarchy_helper.entity.RewardActionRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardActionRequirementRepository extends JpaRepository<RewardActionRequirement, Integer> {
}
