package com.vitals.api.dto;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@JsonRootName("vital")
@Data
public class VitalsDTO implements Serializable{

	private String id;

	@JsonProperty(value = "systolic", required = true)
	private double systolic;

	@JsonProperty(value = "diastolic", required = true)
	private double diastolic;

	@JsonProperty(value = "pulse", required = true)
	private double pulse;

	@JsonProperty(value = "respirations", required = true)
	private double respirations;

	@JsonProperty(value = "spo2", required = true)
	private double spo2;

	@JsonProperty(value = "temperature", required = true)
	@NotNull(message = "temparature value should be present")
	private double temperature;
	
	@JsonProperty(value = "patient_id", required = true)
	@NotNull(message = "patient id value must be present")
	private String patientId;

	
	private Date createdOn;

	
	private String createdBy;

}
