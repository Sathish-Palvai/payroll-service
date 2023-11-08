package com.example.payrollservice.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.payrollservice.persistence.entities.TaxEntity;

@Repository
public interface TaxRepository extends JpaRepository<TaxEntity, Integer> {
}
