package com.example.the_anarchy_helper.repository;

import com.example.the_anarchy_helper.entity.RewardAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RewardActionsRepository extends JpaRepository<RewardAction, Integer> {
    List<RewardAction> findByIdIn(List<Integer> ids);
}
