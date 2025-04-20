package mini_project.insurance.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import mini_project.insurance.entity.CitizenPlan;
import mini_project.insurance.repo.CitizenPlanRepo;
@Component
public class DataLoader implements ApplicationRunner{
	@Autowired
	private CitizenPlanRepo repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repo.deleteAll();
		
		// CASH PLAN DATA
		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("Govind");
		c1.setGender("male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenefitAmount(29839837.00);
		
		CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("Ganga");
		c4.setGender("female");
		c4.setPlanName("Cash");
		c4.setPlanStatus("Denied");
		c4.setBenefitAmount(839837.00);
		c4.setDenialReason("Good Sweet Harted Girl");
		
		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("Rajeshwari");
		c2.setGender("female");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setBenefitAmount(2989039837.00);
		c2.setDenialReason("deserve better than requested");
		
		CitizenPlan c5 = new CitizenPlan();
		c5.setCitizenName("Shree");
		c5.setGender("male");
		c5.setPlanName("Cash");
		c5.setPlanStatus("Approvedd");
		c5.setPlanStartDate(LocalDate.now());
		c5.setPlanEndDate(LocalDate.now().plusMonths(6));
		c5.setBenefitAmount(839837.00);
		
		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("Neethu");
		c3.setGender("female");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(2));
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenefitAmount(2989039837.00);
		c3.setTeminateDate(LocalDate.now());
		c3.setTeminationReason("Out of control");
		
		CitizenPlan c6 = new CitizenPlan();
		c6.setCitizenName("Vinay");
		c6.setGender("male");
		c6.setPlanName("Cash");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now().minusMonths(2));
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBenefitAmount(2989039837.00);
		c6.setTeminateDate(LocalDate.now());
		c6.setTeminationReason("Married");
		
		// Food PLAN DATA
				CitizenPlan c7 = new CitizenPlan();
				c7.setCitizenName("Kamal");
				c7.setGender("male");
				c7.setPlanName("Food");
				c7.setPlanStatus("Approved");
				c7.setPlanStartDate(LocalDate.now());
				c7.setPlanEndDate(LocalDate.now().plusMonths(6));
				c7.setBenefitAmount(29839837.00);
				
				CitizenPlan c8 = new CitizenPlan();
				c8.setCitizenName("Manika");
				c8.setGender("female");
				c8.setPlanName("Food");
				c8.setPlanStatus("Denied");
				c8.setBenefitAmount(839837.00);
				c8.setDenialReason("Good Sweet Harted Girl");
				
				CitizenPlan c9 = new CitizenPlan();
				c9.setCitizenName("Anamika");
				c9.setGender("female");
				c9.setPlanName("Food");
				c9.setPlanStatus("Denied");
				c9.setBenefitAmount(2989039837.00);
				c9.setDenialReason("deserve better than requested");
				
				CitizenPlan c10 = new CitizenPlan();
				c10.setCitizenName("Nibedan");
				c10.setGender("male");
				c10.setPlanName("Food");
				c10.setPlanStatus("Approvedd");
				c10.setPlanStartDate(LocalDate.now());
				c10.setPlanEndDate(LocalDate.now().plusMonths(6));
				c10.setBenefitAmount(839837.00);
				
				CitizenPlan c11 = new CitizenPlan();
				c11.setCitizenName("Sowmya");
				c11.setGender("female");
				c11.setPlanName("Food");
				c11.setPlanStatus("Terminated");
				c11.setPlanStartDate(LocalDate.now().minusMonths(2));
				c11.setPlanEndDate(LocalDate.now().plusMonths(6));
				c11.setBenefitAmount(2989039837.00);
				c11.setTeminateDate(LocalDate.now());
				c11.setTeminationReason("Out of control");
				
				CitizenPlan c12 = new CitizenPlan();
				c12.setCitizenName("Sarthak");
				c12.setGender("male");
				c12.setPlanName("Food");
				c12.setPlanStatus("Terminated");
				c12.setPlanStartDate(LocalDate.now().minusMonths(2));
				c12.setPlanEndDate(LocalDate.now().plusMonths(6));
				c12.setBenefitAmount(2989039837.00);
				c12.setTeminateDate(LocalDate.now());
				c12.setTeminationReason("Married");
				
		// Medical PLAN DATA
				CitizenPlan c13 = new CitizenPlan();
				c13.setCitizenName("Rahul");
				c13.setGender("male");
				c13.setPlanName("Medical");
				c13.setPlanStatus("Approved");
				c13.setPlanStartDate(LocalDate.now());
				c13.setPlanEndDate(LocalDate.now().plusMonths(6));
				c13.setBenefitAmount(29839837.00);
				
				CitizenPlan c14 = new CitizenPlan();
				c14.setCitizenName("Suchitra");
				c14.setGender("female");
				c14.setPlanName("Medical");
				c14.setPlanStatus("Denied");
				c14.setBenefitAmount(839837.00);
				c14.setDenialReason("Good Sweet Harted Girl");
				
				CitizenPlan c15 = new CitizenPlan();
				c15.setCitizenName("Nandini");
				c15.setGender("female");
				c15.setPlanName("Medical");
				c15.setPlanStatus("Denied");
				c15.setBenefitAmount(2989039837.00);
				c15.setDenialReason("deserve better than requested");
				
				CitizenPlan c16 = new CitizenPlan();
				c16.setCitizenName("Abinash");
				c16.setGender("male");
				c16.setPlanName("Medical");
				c16.setPlanStatus("Approvedd");
				c16.setPlanStartDate(LocalDate.now());
				c16.setPlanEndDate(LocalDate.now().plusMonths(6));
				c16.setBenefitAmount(839837.00);
				
				CitizenPlan c17 = new CitizenPlan();
				c17.setCitizenName("Umme");
				c17.setGender("female");
				c17.setPlanName("Medical");
				c17.setPlanStatus("Terminated");
				c17.setPlanStartDate(LocalDate.now().minusMonths(2));
				c17.setPlanEndDate(LocalDate.now().plusMonths(6));
				c17.setBenefitAmount(2989039837.00);
				c17.setTeminateDate(LocalDate.now());
				c17.setTeminationReason("Out of control");
				
				CitizenPlan c18 = new CitizenPlan();
				c18.setCitizenName("Umesh");
				c18.setGender("male");
				c18.setPlanName("Medical");
				c18.setPlanStatus("Terminated");
				c18.setPlanStartDate(LocalDate.now().minusMonths(2));
				c18.setPlanEndDate(LocalDate.now().plusMonths(6));
				c18.setBenefitAmount(2989039837.00);
				c18.setTeminateDate(LocalDate.now());
				c18.setTeminationReason("Married");
				// Employment PLAN DATA
				CitizenPlan c19 = new CitizenPlan();
				c19.setCitizenName("Nabil");
				c19.setGender("male");
				c19.setPlanName("Employment");
				c19.setPlanStatus("Approved");
				c19.setPlanStartDate(LocalDate.now());
				c19.setPlanEndDate(LocalDate.now().plusMonths(6));
				c19.setBenefitAmount(29839837.00);
				
				CitizenPlan c20 = new CitizenPlan();
				c20.setCitizenName("Sagaya");
				c20.setGender("female");
				c20.setPlanName("Employment");
				c20.setPlanStatus("Denied");
				c20.setBenefitAmount(839837.00);
				c20.setDenialReason("Good Sweet Harted Girl");
				
				CitizenPlan c21 = new CitizenPlan();
				c21.setCitizenName("Deeksha");
				c21.setGender("female");
				c21.setPlanName("Employment");
				c21.setPlanStatus("Denied");
				c21.setBenefitAmount(2989039837.00);
				c21.setDenialReason("deserve better than requested");
				
				CitizenPlan c22 = new CitizenPlan();
				c22.setCitizenName("Ashwin");
				c22.setGender("male");
				c22.setPlanName("Employment");
				c22.setPlanStatus("Approvedd");
				c22.setPlanStartDate(LocalDate.now());
				c22.setPlanEndDate(LocalDate.now().plusMonths(6));
				c22.setBenefitAmount(839837.00);
				
				CitizenPlan c23 = new CitizenPlan();
				c23.setCitizenName("Shishira");
				c23.setGender("female");
				c23.setPlanName("Employment");
				c23.setPlanStatus("Terminated");
				c23.setPlanStartDate(LocalDate.now().minusMonths(2));
				c23.setPlanEndDate(LocalDate.now().plusMonths(6));
				c23.setBenefitAmount(2989039837.00);
				c23.setTeminateDate(LocalDate.now());
				c23.setTeminationReason("Out of control");
				
				CitizenPlan c24 = new CitizenPlan();
				c24.setCitizenName("Vivek");
				c24.setGender("male");
				c24.setPlanName("Employment");
				c24.setPlanStatus("Terminated");
				c24.setPlanStartDate(LocalDate.now().minusMonths(2));
				c24.setPlanEndDate(LocalDate.now().plusMonths(6));
				c24.setBenefitAmount(2989039837.00);
				c24.setTeminateDate(LocalDate.now());
				c24.setTeminationReason("Married");
				
				List<CitizenPlan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24);
				repo.saveAll(list);
	}
}
