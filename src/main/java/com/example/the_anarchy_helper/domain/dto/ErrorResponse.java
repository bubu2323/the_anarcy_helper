package com.example.the_anarchy_helper.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String message;
    private String field;
}
