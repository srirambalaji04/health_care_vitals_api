package com.vitals.api.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitals.api.dto.VitalsDTO;
import com.vitals.api.model.VitalSigns;
import com.vitals.api.services.VitalsService;

import ch.qos.logback.classic.Logger;

@RestController
@RequestMapping(path = "/api/vitals")
public class VitalsController {
	
	Logger logger = (Logger) LoggerFactory.getLogger(VitalsController.class);
	 
	private VitalsService vitalsService;
	
	public VitalsController(VitalsService vitalsService) {
		super();
		this.vitalsService = vitalsService;
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE, path = "/create")	
	private VitalSigns createVitals(@RequestBody VitalsDTO vitals) {
		logger.info("VitalsController --> createVitals:  " + (vitalsService!= null));
		return vitalsService.createVitalForaPatient(vitals);
	}
	
	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE, path = "/findByPatient/{patientId}")
	private List<VitalSigns> findVitalsByPatient(@PathVariable String patientId) {		
		return vitalsService.findVitalsByPatient(patientId);
	}
	
	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE, path = "/findById/{id}")
	private VitalSigns findVitalByID(@PathVariable String id) {
		return vitalsService.findVitalByID(id);
	}
	
	@DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE, path = "/deleteByPatient/{patientId}")
	private VitalSigns deleteVitalsByPatient(@PathVariable String patientId) {
		return vitalsService.deleteVitalsByPatient(patientId);
	}
	
	@DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE, path = "/deleteById/{vitalsId}")
	private VitalSigns deleteVitalsById(@PathVariable String vitalsId) {
		return vitalsService.deleteVitalsById(vitalsId);
	}

}
