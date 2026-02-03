package com.example.analytics.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Map;

public record QueryRequest(
        @NotBlank String datasetId,
        Map<String, Object> filters,
        String groupBy,
        @Size(max = 10) List<@Valid AggregationSpec> aggregations
) {
    public record AggregationSpec(
            @NotBlank String column,
            @NotBlank String op
    ) {
    }
}
