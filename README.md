# Analytics Platform (Self-Service Analytics)

Spring Boot backend for a self-service analytics platform inspired by Tableau.

## What It Does

- Upload CSV datasets
- Infer schema (types + nullability)
- Create a per-dataset table and load rows
- Query with filters, group-by, and aggregations
- Structured errors and validation

## Project Structure

- `backend/` Spring Boot API + processing pipeline
- `processing-cpp/` Optional C++17 processing stub (future extension)

## Run (local)

1. Ensure Java 17 is installed.
2. Configure environment variables (placeholders used by default):
   - `DB_URL` (default `jdbc:postgresql://localhost:5432/analytics`)
   - `DB_USER` (default `analytics`)
   - `DB_PASSWORD` (default `analytics`)
3. From `backend/`:

```powershell
mvn spring-boot:run
```

## API

### Upload Dataset

- `POST /api/v1/datasets/upload` (multipart form-data, `file` part)

```powershell
curl -F "file=@sample.csv" http://localhost:8080/api/v1/datasets/upload
```

### Query Dataset

- `POST /api/v1/datasets/query` (JSON body)

```json
{
  "datasetId": "UUID_FROM_UPLOAD",
  "filters": {
    "region": "east"
  },
  "groupBy": "region",
  "aggregations": [
    { "column": "amount", "op": "SUM" }
  ]
}
```

## Error Format

```json
{
  "errorCode": "VALIDATION_ERROR",
  "message": "datasetId must not be blank",
  "timestamp": "2026-02-03T12:00:00Z",
  "path": "/api/v1/datasets/query"
}
```

## Tests

- Unit tests for CSV inference
- Integration tests using H2 in-memory DB

Note: Maven is required to run tests (`mvn test`). If Maven is not installed, add a Maven Wrapper or install Maven.

## C++ Processing Stub (Optional)

See `processing-cpp/README.md` for build/run instructions.
