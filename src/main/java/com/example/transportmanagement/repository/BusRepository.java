package com.example.transportmanagement.repository;

import com.example.transportmanagement.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
    boolean existsByNumber(String number);
}
