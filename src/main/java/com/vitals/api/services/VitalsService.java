package com.vitals.api.services;

import java.util.List;

import com.vitals.api.dto.VitalsDTO;
import com.vitals.api.model.VitalSigns;

public interface VitalsService {
	
	public VitalSigns createVitalForaPatient(VitalsDTO vitalsPatient);

	public List<VitalSigns> findVitalsByPatient(String patientId);

	public VitalSigns findVitalByID(String id);
	
	public VitalSigns deleteVitalsByPatient(String patientId);
	
	public VitalSigns deleteVitalsById(String vitalsId);

}
