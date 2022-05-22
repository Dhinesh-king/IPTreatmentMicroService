package com.finalProject.entity;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "This is Specialist Detail Entity")
public class SpecDetails
{
	private int specialistDetailId;
	private String name;
	private String areaOfExpertise;
	private int experienceInYears;
	private String contactNumber;
	public int getSpecialistDetailId() {
		return specialistDetailId;
	}
	public void setSpecialistDetailId(int specialistDetailId) {
		this.specialistDetailId = specialistDetailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAreaOfExpertise() {
		return areaOfExpertise;
	}
	public void setAreaOfExpertise(String areaOfExpertise) {
		this.areaOfExpertise = areaOfExpertise;
	}
	public int getExperienceInYears() {
		return experienceInYears;
	}
	public void setExperienceInYears(int experienceInYears) {
		this.experienceInYears = experienceInYears;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}
