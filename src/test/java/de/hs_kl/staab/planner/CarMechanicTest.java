package de.hs_kl.staab.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarMechanicTest {

	@Test
	public void allCarMechanicTest() {

		CarMechanic carMechanic1 = new CarMechanic("KFZ-Mechaniker-1", "1234567890", "Otto@ATU.de");

		assertEquals(carMechanic1.getId(), carMechanic1.getId());
		assertEquals(carMechanic1.getFullName(), carMechanic1.getFullName());
		assertEquals(carMechanic1.getEmailAddress(), carMechanic1.getEmailAddress());
		assertEquals(carMechanic1.getPhoneNumber(), carMechanic1.getPhoneNumber());
	}
}