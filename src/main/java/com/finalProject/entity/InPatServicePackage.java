package com.finalProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InPatServicePackage 
{
	private String AilmentCategory;
	private String TreatmentPackageName;
	private String Testdeatils;
	private int cost;
	private int Treatmentduration;
	public String getAilmentCategory() {
		return AilmentCategory;
	}
	public void setAilmentCategory(String ailmentCategory) {
		AilmentCategory = ailmentCategory;
	}
	public String getTreatmentPackageName() {
		return TreatmentPackageName;
	}
	public void setTreatmentPackageName(String treatmentPackageName) {
		TreatmentPackageName = treatmentPackageName;
	}
	public String getTestdeatils() {
		return Testdeatils;
	}
	public void setTestdeatils(String testdeatils) {
		Testdeatils = testdeatils;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getTreatmentduration() {
		return Treatmentduration;
	}
	public void setTreatmentduration(int treatmentduration) {
		Treatmentduration = treatmentduration;
	}
	
	
}
