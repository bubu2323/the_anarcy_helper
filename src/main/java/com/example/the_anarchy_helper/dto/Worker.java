package com.example.the_anarchy_helper.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Worker extends ResourceType {
    private WorkerType workerType;
    private String color;
}
