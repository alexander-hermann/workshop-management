package de.hs_kl.staab.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VehicleTest {

	@Test
	public void allVehicleTest() {
		Vehicle car1 = new Car("HOM-SB 211", "BMW", "M1", 2016, 2018, 8, 1, null);

		assertEquals(car1.getId(), car1.getId());
		assertEquals(car1.getLicensePlate(), car1.getLicensePlate());
		assertEquals(car1.getBrand(), car1.getBrand());
		assertEquals(car1.getModel(), car1.getModel());
		assertEquals(car1.getYearOfConstruction(), car1.getYearOfConstruction());
	}
}