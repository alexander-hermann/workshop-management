package de.hs_kl.staab.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Appointment {

	@Test
	public void test() {
		WorkingAppointment appointment1 = new WorkingAppointment(2021, 12, 1, 14, 20, null, null, null);
		assertEquals(appointment1, appointment1);
	}

}
