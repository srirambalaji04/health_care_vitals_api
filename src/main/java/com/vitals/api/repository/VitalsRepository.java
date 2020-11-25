package com.vitals.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitals.api.model.VitalSigns;


public interface VitalsRepository extends JpaRepository<VitalSigns, String>, VitalRepositoryCustom {

}
