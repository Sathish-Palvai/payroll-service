package com.example.payrollservice.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.payrollservice.persistence.entities.BenefitEntity;

@Repository
public interface BenefitRepository extends JpaRepository<BenefitEntity, Integer> {
}
