package com.example.payrollservice.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.payrollservice.persistence.entities.PayrollEntity;

@Repository
public interface PayrollRepository extends JpaRepository<PayrollEntity, Integer> {
}
