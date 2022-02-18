package de.hs_kl.staab.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CustomerTest {

	@Test
	public void allServiceTest() {

		// // @formatter:off
		Customer customer1 = new Customer("Ammar Said", null, "+49176 258484750", "ammar@web.de");
		
		assertEquals("CS-1", customer1.getId());
		assertEquals("Ammar Said", customer1.getFullName());
		assertEquals("+49176 258484750", customer1.getPhoneNumber());
		assertEquals("ammar@web.de", customer1.getEmailAddress());
	}
}