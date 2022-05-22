package com.finalProject.service;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.finalProject.controller.IPMController;
import com.finalProject.entity.InPatServicePackage;
import com.finalProject.entity.PatientDetail;
import com.finalProject.entity.SpecDetails;
import com.finalProject.entity.TreatmentPlan;
import com.finalProject.repo.PatientDetailRepository;
import com.finalProject.repo.TreatmentPlanRepository;

@Service
public class IPMServiceImpl implements IPMService {
	@Autowired
	private PatientDetailRepository patientDetailRepo;

	@Autowired
	private TreatmentPlanRepository treatmentPlanRepo;

	@Autowired
	private RestTemplate restTemplate;

	Logger logger=LoggerFactory.getLogger(IPMController.class); 
	
	@Override
	public TreatmentPlan getTreatmentPlan(PatientDetail patientDetail) {

		String packageName = patientDetail.getTreatmentPackageName();
		String ailment = patientDetail.getAilment();
		Date date = patientDetail.getTreatmentCommencementDate();
		String url = "http://localhost:8081/offerings/IPTreatmentPackageByName/" + packageName;
		logger.info("Obtainining the list of patient Service packages based on Package Name from International Patient Treatment Offerings MicroService....");
		
		ResponseEntity<InPatServicePackage[]> responseEntity = restTemplate.getForEntity(url,
				InPatServicePackage[].class);
		logger.info("SucessFully obtained the list of patient Service packages based on Package Name from International Patient Treatment Offerings MicroService....");
		
		List<InPatServicePackage> l = Arrays.asList(responseEntity.getBody());
		TreatmentPlan tp = new TreatmentPlan();

		String url1 = "http://localhost:8081/offerings/Specialists";
		logger.info("Obtainining the list of Specialists from International Patient Treatment Offerings MicroService..");
		
		ResponseEntity<SpecDetails[]> responseEntity1 = restTemplate.getForEntity(url1, SpecDetails[].class);
		logger.info("Obtained the list of Specialists from International Patient Treatment Offerings MicroService..");
		
		List<SpecDetails> l1 = Arrays.asList(responseEntity1.getBody());

		String pac = "";
		for (InPatServicePackage ips : l) {
			if (ips.getAilmentCategory().equals(ailment)) {
				tp.setPackageName(ips.getTreatmentPackageName());
				pac = ips.getTreatmentPackageName();
				tp.setCost(ips.getCost());
				tp.setTreatmentCommencementDate(date);
				int weeks = ips.getTreatmentduration();
				int noOfDays = weeks * 7; // i.e two weeks
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
				Date newDate = calendar.getTime();
				tp.setTreatmentEndDate(newDate);
				tp.setTestDetails(ips.getTestdeatils());
			}
		}
		for (SpecDetails sd : l1) {
			if (sd.getAreaOfExpertise().equals(ailment))

			{
				if (pac.equals("Package1")) {
					if (sd.getExperienceInYears() <= 5) {
						tp.setSpecialist(sd.getName());
					}
				} else {
					if (sd.getExperienceInYears() > 5) {
						tp.setSpecialist(sd.getName());
					}
				}
			}
		}

		TreatmentPlan treatmentPlan=treatmentPlanRepo.save(tp);
		logger.info("Saved the Treatment Plan to the database.");
		patientDetailRepo.save(patientDetail);
		logger.info("Saved the Patient Detail to the database.");
		return treatmentPlan;

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public TreatmentPlan getTreatmentPlanByPatientName(String name) {
		PatientDetail patientDetail = patientDetailRepo.findByName(name).get();
		logger.info("Returning the Treatment Plan based on patiend Id..");
		return treatmentPlanRepo.findById(patientDetail.getPatientDetailId()).get();
	}

	@Override
	public PatientDetail getPatientById(Integer patientId) {
		return patientDetailRepo.findById(patientId).get();
	}

	@Override
	public List<PatientDetail> getAllPatientDetails() {
		return patientDetailRepo.findAll();
	}

	@Override
	public PatientDetail updatePatientDetail(PatientDetail patientdetail) {
		try {
			patientDetailRepo.deleteById(patientdetail.getPatientDetailId());
		}
		catch(IllegalArgumentException e) {
			logger.error("The Patient Detail Id is Null");
			logger.trace(e.toString());
			return null;
		}
		return patientDetailRepo.save(patientdetail);
	}

}
