package com.finalProject.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finalProject.entity.PatientDetail;
import com.finalProject.entity.TreatmentPlan;
import com.finalProject.service.IPMService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/treatment")
@Api(value = "International Patient Treatment Microservice Controller",description = "REST API's Related To Treatment plan and Treatment TimeTable")
public class IPMController 
{
	@Autowired
	private IPMService ipmService;
	
	Logger logger=LoggerFactory.getLogger(IPMController.class); 
	
	@GetMapping(value="/getTreatmentPlanByPatientName/{patientName}")
	@ApiOperation(value = "The method to get Treatment based on the patient name")
	public TreatmentPlan getTreatmentPlanByPatientName(@PathVariable String patientName) {
		
		logger.info("The Controller is returning Treatment Plan based on the patient name...");
		return ipmService.getTreatmentPlanByPatientName(patientName);
	}
	
	
	@PostMapping("/FormulateTreatmentTimetable")
	@ApiOperation(value = "The method to get Treatment based on the patient Details")
	public TreatmentPlan getTreatmentPlan(@RequestBody PatientDetail pd)
	{
		pd.setStatus("In-Progress");
		logger.info("The Controller is returning Treatment Plan for the given Patient Detail...");
		return ipmService.getTreatmentPlan(pd);
	}
	
	@GetMapping("/allPatients")
	@ApiOperation(value = "The method to get all the patient Details")
	public ResponseEntity<List<PatientDetail>> getAllPatientDetails(){
		List<PatientDetail> allPatients=ipmService.getAllPatientDetails();
		logger.info("The Controller is returning All the Patient Details...");
		
		return new ResponseEntity<>(allPatients,HttpStatus.OK);
	}

	@GetMapping("/getById/{patientId}")
	public ResponseEntity<PatientDetail> getPatientById(@PathVariable Integer patientId){
		logger.info("Patient Detail is returned by Id..");
		return new ResponseEntity<PatientDetail>(ipmService.getPatientById(patientId),HttpStatus.OK);
	}

	@PostMapping("/updatePatient")
	public ResponseEntity<PatientDetail> updatePatient(@RequestBody PatientDetail patientDetail){
		ipmService.updatePatientDetail(patientDetail);
		return new ResponseEntity<>(patientDetail,HttpStatus.OK);
	}


}
