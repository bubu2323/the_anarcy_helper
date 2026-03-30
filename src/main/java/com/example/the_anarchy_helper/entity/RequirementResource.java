package com.example.the_anarchy_helper.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;

@Data
@Table(name = "requirements_resources")
@Entity
@NoArgsConstructor
public class RequirementResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "reward_actions_requirements_id", nullable = false)
    private RewardActionRequirement rewardActionsRequirements;

    @ManyToOne
    @JoinColumn(name = "resource_id", nullable = false)
    private Resource resource;
}
