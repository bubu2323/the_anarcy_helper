package com.example.the_anarchy_helper.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="requirements")
@Data
@NoArgsConstructor
public class Requirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="is_action", nullable = false)
    private Boolean isAction;

    @Column(name="is_resource", nullable = false)
    private Boolean isResource;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource requirementId;

    @ManyToOne
    @JoinColumn(name= "prerequisite_action_id")
    private PrerequisiteAction prerequisiteAction;


}
