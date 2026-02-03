package com.example.analytics.repository;

import com.example.analytics.model.DatasetColumn;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DatasetColumnRepository extends JpaRepository<DatasetColumn, UUID> {
}
