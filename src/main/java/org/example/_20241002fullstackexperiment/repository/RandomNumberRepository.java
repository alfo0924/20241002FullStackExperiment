package org.example._20241002fullstackexperiment.repository;

import org.example._20241002fullstackexperiment.model.RandomNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RandomNumberRepository extends JpaRepository<RandomNumber, Long> {
}