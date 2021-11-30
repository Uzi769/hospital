package com.golovin.hospital.repository;

import com.golovin.hospital.dao.entity.MedicalStaff;
import com.golovin.hospital.dao.entity.Patient;
import com.golovin.hospital.dto.response.PatientResponse;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @EntityGraph(value = "patient.medicals", type = EntityGraph.EntityGraphType.FETCH)
    List<Patient> findAllByMedicals(MedicalStaff medical);
}
