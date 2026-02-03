CREATE TABLE IF NOT EXISTS datasets (
    id UUID PRIMARY KEY,
    name TEXT NOT NULL,
    original_filename TEXT,
    status TEXT NOT NULL,
    created_at TIMESTAMPTZ NOT NULL,
    updated_at TIMESTAMPTZ NOT NULL
);

CREATE TABLE IF NOT EXISTS dataset_columns (
    id UUID PRIMARY KEY,
    dataset_id UUID NOT NULL REFERENCES datasets(id) ON DELETE CASCADE,
    name TEXT NOT NULL,
    data_type TEXT NOT NULL,
    nullable BOOLEAN NOT NULL,
    ordinal_position INT NOT NULL
);

CREATE INDEX IF NOT EXISTS idx_dataset_columns_dataset_id ON dataset_columns(dataset_id);
