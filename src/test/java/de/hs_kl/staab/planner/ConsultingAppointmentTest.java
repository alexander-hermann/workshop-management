package de.hs_kl.staab.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ConsultingAppointmentTest {

	@Test
	public void allConsultingAppointmentTest() {

		InvoiceAddress invoiceAddressOfCustomer1 = new InvoiceAddress("Hauptstraße", 20, 66840, "Zweibrücken");
		Customer customer1 = new Customer("Ammar Said", invoiceAddressOfCustomer1, "+49176 258484750", "ammar@web.de");
		CustomerConsultant customerConsultant1 = new CustomerConsultant("Kundenberater-2", "1234547890-2",
				"Ralph@ATU.de");
		ConsultingAppointment consultingAppointment1 = new ConsultingAppointment(2021, 12, 20, 8, 00, customer1, 1,
				customerConsultant1);

		assertEquals(consultingAppointment1.getDayWithStartTime(), consultingAppointment1.getDayWithStartTime());
		assertEquals(consultingAppointment1.getDayWithEndTime(), consultingAppointment1.getDayWithEndTime());
		assertEquals(consultingAppointment1.getCustomerConsultant(), consultingAppointment1.getCustomerConsultant());
		assertEquals(consultingAppointment1.getCustomer(), consultingAppointment1.getCustomer());
	}
}