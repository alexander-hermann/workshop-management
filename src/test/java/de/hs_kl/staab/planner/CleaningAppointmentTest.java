package de.hs_kl.staab.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CleaningAppointmentTest {

	@Test
	public void allCleaningAppointmentTest() {

		WorkingPlatform wkp1 = new WorkingPlatform("Arbeitsbühne1");
		Dispatcher dispatcher1 = new Dispatcher("Dispo Person", "1232567890", "Herbert@ATU.de");
		CleaningAppointment cleaningAppointment1 = new CleaningAppointment(2022, 2, 18, 8, 00, wkp1,
				CLEANINGPROGRAMM.FAST, dispatcher1);

		assertEquals(cleaningAppointment1.getId(), cleaningAppointment1.getId());
		assertEquals(cleaningAppointment1.getDispatcher(), cleaningAppointment1.getDispatcher());
		assertEquals(cleaningAppointment1.getWorkingPlatform(), cleaningAppointment1.getWorkingPlatform());
		assertEquals(cleaningAppointment1.getDurationOfCleaningInH(), cleaningAppointment1.getDurationOfCleaningInH());
	}
}