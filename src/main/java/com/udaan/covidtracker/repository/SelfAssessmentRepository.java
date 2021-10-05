package com.udaan.covidtracker.repository;

import com.udaan.covidtracker.entity.SelfAssessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelfAssessmentRepository extends JpaRepository<SelfAssessment,Integer> {
}
