package com.example.the_anarchy_helper.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "reward_action_results")
public class RewardActionResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "reward_action_id", nullable = false)
    private RewardAction rewardAction;
    @ManyToOne
    @JoinColumn(name = "resource_id", nullable = false)
    private Resource resource;

}
