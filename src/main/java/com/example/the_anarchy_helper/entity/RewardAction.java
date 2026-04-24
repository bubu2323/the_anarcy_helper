package com.example.the_anarchy_helper.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "reward_actions")
public class RewardAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "action_name", nullable = false)
    private String actionName;
    @Column(nullable = false)
    private Boolean immediate;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;
}
