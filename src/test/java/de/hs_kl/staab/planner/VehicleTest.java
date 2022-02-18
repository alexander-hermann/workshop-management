package de.hs_kl.staab.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VehicleTest {

	@Test
	public void allVehicleTest() {
		Vehicle car1 = new Car("HOM-SB 211", "BMW", "M1", 2016, 2018, 8, 1, null);

		assertEquals("VH-1", car1.getId());
		assertEquals("HOM-SB 211", car1.getLicensePlate());
		assertEquals("BMW", car1.getBrand());
		assertEquals("M1", car1.getModel());
		assertEquals(2016, car1.getYearOfConstruction());
	}
}