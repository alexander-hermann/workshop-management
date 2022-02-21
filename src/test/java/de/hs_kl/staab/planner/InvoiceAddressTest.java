package de.hs_kl.staab.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InvoiceAddressTest {

	@Test
	public void allInvoiceAdressTest() {

		InvoiceAddress invoiceAddressOfCustomer1 = new InvoiceAddress("Hauptstraße", 20, 66840, "Zweibrücken");

		assertEquals(invoiceAddressOfCustomer1.getStreetName(), invoiceAddressOfCustomer1.getStreetName());
		assertEquals(invoiceAddressOfCustomer1.getStreetNumber(), invoiceAddressOfCustomer1.getStreetNumber());
		assertEquals(invoiceAddressOfCustomer1.getCity(), invoiceAddressOfCustomer1.getCity());
		assertEquals(invoiceAddressOfCustomer1.getZipCode(), invoiceAddressOfCustomer1.getZipCode());
	}
}