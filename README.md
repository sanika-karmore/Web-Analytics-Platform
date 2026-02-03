# Analytics Platform (Backend Scaffold)

This is the initial Spring Boot backend scaffold for the self-service analytics platform.

## Run (local)

1. Ensure Java 17 is installed.
2. Configure environment variables (placeholders used by default):
   - `DB_URL`
   - `DB_USER`
   - `DB_PASSWORD`
3. From `backend/`:

```powershell
mvn spring-boot:run
```

## API (stubbed)

- `POST /api/v1/datasets/upload` (multipart form-data, `file` part)
- `POST /api/v1/datasets/query` (JSON body)

The endpoints return stubbed responses for now.
