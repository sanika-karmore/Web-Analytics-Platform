package com.example.analytics.api;

import jakarta.validation.constraints.NotBlank;

public record UploadResponse(
        @NotBlank String datasetId,
        @NotBlank String status,
        String message
) {
}
