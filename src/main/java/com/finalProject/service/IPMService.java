package com.finalProject.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.finalProject.entity.PatientDetail;
import com.finalProject.entity.TreatmentPlan;

public interface IPMService 
{
	public TreatmentPlan getTreatmentPlan(@RequestBody PatientDetail patientdetail);
	public List<PatientDetail> getAllPatientDetails();
	public TreatmentPlan getTreatmentPlanByPatientName(String name);
	public PatientDetail getPatientById(Integer patientId);
	public PatientDetail updatePatientDetail(PatientDetail patientdetail);
}
