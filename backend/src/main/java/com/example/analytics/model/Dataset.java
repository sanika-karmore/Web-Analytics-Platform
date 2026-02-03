package com.example.analytics.model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "datasets")
public class Dataset {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(name = "original_filename")
    private String originalFilename;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DatasetStatus status;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "dataset", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DatasetColumn> columns = new ArrayList<>();

    protected Dataset() {
    }

    public Dataset(String name, String originalFilename, DatasetStatus status) {
        this.name = name;
        this.originalFilename = originalFilename;
        this.status = status;
        this.createdAt = OffsetDateTime.now();
        this.updatedAt = this.createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOriginalFilename() {
        return originalFilename;
    }

    public DatasetStatus getStatus() {
        return status;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public List<DatasetColumn> getColumns() {
        return columns;
    }

    public void setStatus(DatasetStatus status) {
        this.status = status;
        this.updatedAt = OffsetDateTime.now();
    }

    public void addColumn(DatasetColumn column) {
        column.setDataset(this);
        this.columns.add(column);
    }
}
