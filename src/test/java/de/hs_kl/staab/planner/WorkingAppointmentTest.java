package de.hs_kl.staab.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WorkingAppointmentTest {

	@Test
	public void allWorkingAppointmentTest() {

		InvoiceAddress invoiceAddressOfCustomer1 = new InvoiceAddress("Hauptstraße", 20, 66840, "Zweibrücken");
		Customer customer1 = new Customer("Ammar Said", invoiceAddressOfCustomer1, "+49176 258484750", "ammar@web.de");
		Vehicle car1 = new Car("HOM-SB 211", "BMW", "M1", 2016, 2018, 8, 1, customer1);
		WorkingPlatform wkp1 = new WorkingPlatform("Arbeitsbühne1");
		Service oilChange = new Service("Ölwechsel", 0.5);
		Service glassRepair = new Service("Glasreparatur", 2.0);
		CarMechanic carMechanic1 = new CarMechanic("Auto Meschaniker", "1234567890", "Otto@ATU.de");

		List<Service> collectionOfWorkForCustomer01 = new ArrayList<Service>();
		collectionOfWorkForCustomer01.add(oilChange);
		collectionOfWorkForCustomer01.add(glassRepair);

		WorkingAppointment workingAppointment01 = new WorkingAppointment(2022, 2, 19, 8, 00, wkp1, car1,
				collectionOfWorkForCustomer01, carMechanic1);

		assertEquals("AP-1", workingAppointment01.getId());
		assertEquals(workingAppointment01.getCalendarWeek(), workingAppointment01.getCalendarWeek());
		assertEquals(workingAppointment01.getCarMechanic(), workingAppointment01.getCarMechanic());
		assertEquals(workingAppointment01.getDay(), workingAppointment01.getDay());
		assertEquals(workingAppointment01.getWorkingPlatform(), workingAppointment01.getWorkingPlatform());
		assertEquals(workingAppointment01.getStart(), workingAppointment01.getStart());
		assertEquals(workingAppointment01.getDurationInMin(), workingAppointment01.getDurationInMin());

	}
}