package com.finalProject.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "This is Patient Detail Entity")
public class PatientDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int patientDetailId;
	@NotNull
	@Size(min = 2)
	@Column
	private String name;
	@NotNull
	@NumberFormat
	@Column
	private int age;
	@NotNull
	@Size(min = 5)
	@Column
	private String ailment;
	@NotNull
	@Size(min = 5)
	@Column
	private String treatmentPackageName;
	@NotNull
	private Date treatmentCommencementDate;
	@Column
	private String status;

	public int getPatientDetailId() {
		return patientDetailId;
	}

	public void setPatientDetailId(int patientDetailId) {
		this.patientDetailId = patientDetailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAilment() {
		return ailment;
	}

	public void setAilment(String ailment) {
		this.ailment = ailment;
	}

	public String getTreatmentPackageName() {
		return treatmentPackageName;
	}

	public void setTreatmentPackageName(String treatmentPackageName) {
		this.treatmentPackageName = treatmentPackageName;
	}

	public Date getTreatmentCommencementDate() {
		return treatmentCommencementDate;
	}

	public void setTreatmentCommencementDate(Date treatmentCommencementDate) {
		this.treatmentCommencementDate = treatmentCommencementDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
