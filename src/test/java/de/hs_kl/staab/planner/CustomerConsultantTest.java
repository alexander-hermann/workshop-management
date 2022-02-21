package de.hs_kl.staab.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CustomerConsultantTest {

	@Test
	public void allCustomerConsultantTest() {
		CustomerConsultant customerConsultant1 = new CustomerConsultant("Kundenberater-1", "1234547890-1",
				"Ralph@ATU.de");

		assertEquals(customerConsultant1.getId(), customerConsultant1.getId());
		assertEquals(customerConsultant1.getFullName(), customerConsultant1.getFullName());
		assertEquals(customerConsultant1.getEmailAddress(), customerConsultant1.getEmailAddress());
		assertEquals(customerConsultant1.getPhoneNumber(), customerConsultant1.getPhoneNumber());
	}
}