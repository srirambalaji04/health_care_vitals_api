package com.vitals.api.model;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "vitals")
public class VitalSigns implements Serializable{

	@Id	
	@GenericGenerator(name = "sequence_dep_id", strategy = "com.vitals.api.model.generator.StringIdGenerator")
	@GeneratedValue(generator = "sequence_dep_id") 
	private String id;
	
	@Column(name = "patient_id", nullable = false)
	private String patientId;
	
	@Column(nullable = false)
	private long systolic;
	
	@Column(nullable = false)
	private long diastolic;
	
	@Column(nullable = false)
	private long pulse;
	
	@Column(nullable = false)
	private long respirations;
	
	@Column(nullable = false)
	private long spo2;
	
	@Column(nullable = false)
	private double temperature;
	
	@Column(name = "created_on")
	private Date createdOn;
	
	@Column(name = "created_by")
	private String createdBy;
	/*private String modifiedOn;
	private String modifiedBy;*/


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getSystolic() {
		return systolic;
	}

	public void setSystolic(long systolic) {
		this.systolic = systolic;
	}

	public long getDiastolic() {
		return diastolic;
	}

	public void setDiastolic(long diastolic) {
		this.diastolic = diastolic;
	}

	public long getPulse() {
		return pulse;
	}

	public void setPulse(long pulse) {
		this.pulse = pulse;
	}

	public long getRespirations() {
		return respirations;
	}

	public void setRespirations(long respirations) {
		this.respirations = respirations;
	}

	public long getSpo2() {
		return spo2;
	}

	public void setSpo2(long spo2) {
		this.spo2 = spo2;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof VitalSigns)) {
			return false;
		}
		VitalSigns other = (VitalSigns) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "VitalSigns [id=" + id + ", patientId=" + patientId + ", systolic=" + systolic + ", diastolic="
				+ diastolic + ", pulse=" + pulse + ", respirations=" + respirations + ", spo2=" + spo2
				+ ", temperature=" + temperature + ", createdOn=" + createdOn + ", createdBy=" + createdBy + "]";
	}
	

}
