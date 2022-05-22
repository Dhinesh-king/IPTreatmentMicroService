//package com.training.repo;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.util.Date;
//
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import com.finalProject.entity.PatientDetail;
//import com.finalProject.repo.PatientDetailRepository;
//
//@AutoConfigureDataJpa
//public class PatientDetailsRepoTests {
//
//	@Autowired
//	private PatientDetailRepository patientDetailRepo;
//
//	@Test
//	@Order(1)
//	void testSavePatienDetail() {
//		PatientDetail patientDetail=new PatientDetail(1,"Dhinesh",21,"ailment1","packageName1",new Date(),"In-Progress");
//		PatientDetail savedpatientDetail=patientDetailRepo.save(patientDetail);
//		assertNotNull(savedpatientDetail);
//		assertEquals(patientDetail.getName(),savedpatientDetail.getName());
//	}
//	@Test
//	@Order(2)
//	void testSavePatienDetailInvalid() {
//		PatientDetail patientDetail=new PatientDetail(1,"Dh",21,"ailment1","packageName1",new Date(),"In-Progress");
//		PatientDetail savedpatientDetail=patientDetailRepo.save(patientDetail);
//		assertNotNull(savedpatientDetail);
//		assertEquals(patientDetail.getName(),savedpatientDetail.getName());
//	}
//
//	@Test
//	@Order(3)
//	public void testGetPateintDetailById() {
//		PatientDetail patientDetail=new PatientDetail(1,"Dhinesh",21,"ailment1","packageName1",new Date(),"In-Progress");
//		PatientDetail savedpatientDetail=patientDetailRepo.save(patientDetail);
//		assertNotNull(savedpatientDetail);
//		assertEquals(patientDetail.getName(),patientDetailRepo.findById(1).get().getName());	
//	}
//}
