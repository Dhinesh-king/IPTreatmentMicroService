//package com.training.service;
//
//import static org.hamcrest.CoreMatchers.any;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.web.client.RestTemplate;
//
//import com.finalProject.entity.PatientDetail;
//import com.finalProject.entity.TreatmentPlan;
//import com.finalProject.repo.PatientDetailRepository;
//import com.finalProject.repo.TreatmentPlanRepository;
//import com.finalProject.service.IPMService;
//
//@SpringBootTest(classes=com.training.service.IPMServiceImplTests.class)
//class IPMServiceImplTests {
//
//	@MockBean
//	private PatientDetailRepository patientDetailRepo;
//
//	@MockBean
//	private TreatmentPlanRepository treatmentPlanRepo;
//
////	@MockBean
////	private RestTemplate restTemplate;
//
//	@MockBean
//	private IPMService ipmService;
//	
//	@Autowired
//	private IPMService ipService;
//
//	@Test
//	public void testgetTreatmentPlan() {
//		PatientDetail patientDetail = new PatientDetail(1, "Dhinesh", 21, "ailment1", "Package1", new Date(),"In-Progress");
////		TreatmentPlan treatmentPlan=new TreatmentPlan(1,"Package1","Orthopaedics");
////		InPatServicePackage[] ipPackages = {
////				new InPatServicePackage("Orthopaedics", "Package1", "OPT1,OPT2", 2500, 4) };
////		SpecDetails[] specList = { new SpecDetails(1, "foo", "Orthopaedics", 8, "1234567890"),
////				new SpecDetails(2, "huff", "Orthopaedics", 4, "0987654321"),
////				new SpecDetails(3, "abc", "Urology", 10, "8762684158"),
////				new SpecDetails(4, "def", "Urology", 5, "7621146542") };
////		when(restTemplate.getForObject("http://localhost:8081/IPTreatmentPackageByName/packageName1",
////				InPatServicePackage[].class)).thenReturn(ipPackages);
////		when(restTemplate.getForObject("http://localhost:8081/Specialists", SpecDetails[].class)).thenReturn(specList);
////		when(patientDetailRepo.save(any(treatmentPlan)).thenReturn(treatmentPlan);
//		TreatmentPlan treatmentPlan=new TreatmentPlan(1,"Package1","Orthopaedics",12000,"Junior",new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()+1200));
//		when(treatmentPlanRepo.save(treatmentPlan)).thenReturn(treatmentPlan);
//		when(ipmService.getTreatmentPlan(patientDetail)).thenReturn(treatmentPlan);
//		assertEquals(treatmentPlan.getPackageName(), ipmService.getTreatmentPlan(patientDetail).getPackageName());
//	}
//
//	@Test
//	public void testgetPateintDetailByName() {
//		Optional<PatientDetail> patientDetail = Optional.of(new PatientDetail(1, "Dhinesh", 21, "ailment1", "Package1", new Date(),"In-Progress"));
//		when(patientDetailRepo.findByName("Dhinesh")).thenReturn(patientDetail);
//		Optional<TreatmentPlan> treatmentPlan=Optional.of(new TreatmentPlan(1,"Package1","Orthopaedics",12000,"Junior",new Date(System.currentTimeMillis()),new Date(System.currentTimeMillis()+1200)));
//		when(treatmentPlanRepo.findById(1)).thenReturn(treatmentPlan);
//		assertEquals(patientDetail.get().getTreatmentPackageName(),ipService.getTreatmentPlanByPatientName("Dhinesh").getPackageName());
//	}
//}
