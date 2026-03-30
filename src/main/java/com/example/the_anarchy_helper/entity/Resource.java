package com.example.the_anarchy_helper.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Null;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "resources")
@NoArgsConstructor
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Resource name cannot be empty or blank")
    private String name;

    @Null
    private String color;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryId;

}
