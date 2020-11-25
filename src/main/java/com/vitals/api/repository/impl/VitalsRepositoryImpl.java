package com.vitals.api.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.vitals.api.model.VitalSigns;
import com.vitals.api.repository.VitalRepositoryCustom;

import ch.qos.logback.classic.Logger;

@Repository
public class VitalsRepositoryImpl implements VitalRepositoryCustom {
	
	Logger logger = (Logger) LoggerFactory.getLogger(VitalsRepositoryImpl.class);
	
	@Autowired
	private EntityManager em;

	@Override
	public List<VitalSigns> findVitalsByPatient(String patientId) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<VitalSigns> cq = cb.createQuery(VitalSigns.class);
		
		Root<VitalSigns> vital = cq.from(VitalSigns.class);
		List<Predicate> predicates = new ArrayList<>();
		
		if (patientId != null) {
	        predicates.add(cb.like(vital.get("patientId"), "%" + patientId + "%"));//should use the entity variable name instead of the column
	    }
		
		cq.where(predicates.toArray(new Predicate[0]));
		

		logger.info("patientId : " + patientId);
		
		
		Query query = em.createQuery(cq);
		
		
		
		@SuppressWarnings("unchecked")
		List<VitalSigns> vitals = query.getResultList();
		logger.info("vitals: " + vitals.size());
		
		return null;
	}

	@Override
	public VitalSigns findVitalByID(String id) {
		
		return null;
	}

	@Override
	public VitalSigns deleteVitalsByPatient(String patientId) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaDelete<VitalSigns> cq = cb.createCriteriaDelete(VitalSigns.class);
	
		
		Root<VitalSigns> vital = cq.from(VitalSigns.class);
		List<Predicate> predicates = new ArrayList<>();
		
		if (patientId != null) {
	        predicates.add(cb.like(vital.get("patientId"), "%" + patientId + "%"));//should use the entity variable name instead of the column
	    }
		
		cq.where(predicates.toArray(new Predicate[0]));
		

		logger.info("patientId : " + patientId);
		
		
		Query query = em.createQuery(cq);
		
		
		int noOfVitals = query.executeUpdate();
		logger.info("vitals: " + noOfVitals);
		
		return null;
	}

}
