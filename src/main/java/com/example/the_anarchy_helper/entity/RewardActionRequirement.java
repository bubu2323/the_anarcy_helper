package com.example.the_anarchy_helper.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="reward_actions_requirements")
public class RewardActionRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="requirement_id")
    private Requirement requirement;

}
