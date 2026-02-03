package com.example.analytics.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "dataset_columns")
public class DatasetColumn {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dataset_id", nullable = false)
    private Dataset dataset;

    @Column(nullable = false)
    private String name;

    @Column(name = "data_type", nullable = false)
    private String dataType;

    @Column(nullable = false)
    private boolean nullable;

    @Column(name = "ordinal_position", nullable = false)
    private int ordinalPosition;

    protected DatasetColumn() {
    }

    public DatasetColumn(String name, String dataType, boolean nullable, int ordinalPosition) {
        this.name = name;
        this.dataType = dataType;
        this.nullable = nullable;
        this.ordinalPosition = ordinalPosition;
    }

    public UUID getId() {
        return id;
    }

    public Dataset getDataset() {
        return dataset;
    }

    void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

    public String getName() {
        return name;
    }

    public String getDataType() {
        return dataType;
    }

    public boolean isNullable() {
        return nullable;
    }

    public int getOrdinalPosition() {
        return ordinalPosition;
    }
}
