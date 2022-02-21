package de.hs_kl.staab.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarTest {

	@Test
	public void allCarTest() {

		InvoiceAddress invoiceAddressOfCustomer1 = new InvoiceAddress("Hauptstraße", 20, 66840, "Zweibrücken");
		Customer customer1 = new Customer("Ammar Said", invoiceAddressOfCustomer1, "+49176 258484750", "ammar@web.de");
		Vehicle car1 = new Car("HOM-SB 211", "BMW", "M1", 2016, 2018, 8, 1, customer1);

		assertEquals(car1.getId(), car1.getId());
		assertEquals(car1.getBrand(), car1.getBrand());
		assertEquals(car1.getDateOfAdmission(), car1.getDateOfAdmission());
		assertEquals(car1.getYearOfConstruction(), car1.getYearOfConstruction());
		assertEquals(car1.getLicensePlate(), car1.getLicensePlate());
	}
}
