/**
 * 
 */
package com.vitals.api.services.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitals.api.dto.VitalsDTO;
import com.vitals.api.model.VitalSigns;
import com.vitals.api.repository.VitalsRepository;
import com.vitals.api.services.VitalsService;

import ch.qos.logback.classic.Logger;

/**
 * @author sriram.balaji
 *
 */
@Service
public class VitalsServiceImpl implements VitalsService {
	
	Logger logger = (Logger) LoggerFactory.getLogger(VitalsServiceImpl.class);
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	private VitalsRepository vitalsRepository;
	

	public VitalsServiceImpl(ModelMapper modelMapper, VitalsRepository vitalsRepository) {
		this.modelMapper = modelMapper;
		this.vitalsRepository = vitalsRepository;
	}

	@Override
	public VitalSigns createVitalForaPatient(VitalsDTO vitalsPatient) {
		VitalSigns vitals = toEntity(vitalsPatient);
		
		return vitalsRepository.save(vitals);		
	}

	@Override
	public List<VitalSigns> findVitalsByPatient(String patientId) {
		return vitalsRepository.findVitalsByPatient(patientId);		
	}

	@Override
	public VitalSigns findVitalByID(String id) {
		return vitalsRepository.findById(id).get();
		
	}

	@Override
	public VitalSigns deleteVitalsByPatient(String patientId) {
		vitalsRepository.deleteVitalsByPatient(patientId);
		return null;
	}

	@Override
	public VitalSigns deleteVitalsById(String vitalsId) {
		vitalsRepository.deleteById(vitalsId);
		return null;
	}

	public VitalsDTO toDTO(VitalSigns vital) {
		VitalsDTO dto = modelMapper.map(vital, VitalsDTO.class);
		return dto;
		
	}
	
	public VitalSigns toEntity(VitalsDTO dto) {
		VitalSigns entity = modelMapper.map(dto, VitalSigns.class);
		logger.info("toEntity : " + dto.toString());
		return entity;
	}
	

}
