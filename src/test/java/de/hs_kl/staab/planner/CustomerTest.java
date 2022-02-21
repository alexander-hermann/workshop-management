package de.hs_kl.staab.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CustomerTest {

	@Test
	public void allServiceTest() {

		// // @formatter:off
		Customer customer1 = new Customer("Ammar Said", null, "+49176 258484750", "ammar@web.de");
		
		assertEquals(customer1.getId(), customer1.getId());
		assertEquals(customer1.getFullName(), customer1.getFullName());
		assertEquals(customer1.getPhoneNumber(), customer1.getPhoneNumber());
		assertEquals(customer1.getEmailAddress(), customer1.getEmailAddress());
	}
}