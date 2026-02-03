package com.example.analytics.api;

import java.time.OffsetDateTime;

public record ErrorResponse(
        String errorCode,
        String message,
        OffsetDateTime timestamp,
        String path
) {
}
