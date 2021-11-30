package com.golovin.hospital.repository.specification;

import com.golovin.hospital.dao.entity.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class PatientRepositoryCriteria {

    private final EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;
    private CriteriaQuery<Patient> patientCriteria;
    private Root<Patient> root;

    public List<Patient> filter(){
        criteriaBuilder = entityManager.getCriteriaBuilder();
        patientCriteria = criteriaBuilder.createQuery(Patient.class);
        root = patientCriteria.from(Patient.class);
        TypedQuery<Patient> patientTypedQuery = entityManager.createQuery(patientCriteria).setMaxResults(1);
        return patientTypedQuery.getResultList();

    }



}
