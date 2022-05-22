package com.finalProject.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "This is Patient Treatment Plan Entity")
public class TreatmentPlan 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int treatmentPlanId;
	private String packageName;
	private String testDetails;
	private int cost;
	private String specialist;
	private Date treatmentCommencementDate;
	private Date treatmentEndDate;
	public int getTreatmentPlanId() {
		return treatmentPlanId;
	}
	public void setTreatmentPlanId(int treatmentPlanId) {
		this.treatmentPlanId = treatmentPlanId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getTestDetails() {
		return testDetails;
	}
	public void setTestDetails(String testDetails) {
		this.testDetails = testDetails;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	public Date getTreatmentCommencementDate() {
		return treatmentCommencementDate;
	}
	public void setTreatmentCommencementDate(Date treatmentCommencementDate) {
		this.treatmentCommencementDate = treatmentCommencementDate;
	}
	public Date getTreatmentEndDate() {
		return treatmentEndDate;
	}
	public void setTreatmentEndDate(Date treatmentEndDate) {
		this.treatmentEndDate = treatmentEndDate;
	}
	
	
}
