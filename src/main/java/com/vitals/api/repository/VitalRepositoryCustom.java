package com.vitals.api.repository;

import java.util.List;

import com.vitals.api.model.VitalSigns;

public interface VitalRepositoryCustom {
	
	public List<VitalSigns> findVitalsByPatient(String patientId);
	
	public VitalSigns findVitalByID(String id);
	
	public VitalSigns deleteVitalsByPatient(String patientId);
	
	

}
