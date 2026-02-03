package com.example.analytics.api;

import java.util.List;
import java.util.Map;

public record QueryResponse(
        List<Map<String, Object>> rows,
        long rowCount,
        long elapsedMs
) {
}
