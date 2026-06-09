package com.example.the_anarchy_helper.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class Worker extends ResourceType {
    private WorkerType workerType;
    private String color;
}
