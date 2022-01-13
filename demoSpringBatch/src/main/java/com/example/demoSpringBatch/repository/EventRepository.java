package com.example.demoSpringBatch.repository;

import com.example.demoSpringBatch.entity.EventObject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventObject, Long> {
}
