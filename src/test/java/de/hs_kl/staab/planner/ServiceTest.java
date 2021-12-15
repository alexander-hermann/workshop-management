package de.hs_kl.staab.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.hs_kl.staab.planner.Service;

public class ServiceTest {

	@Test
	public void allServiceTest() {
		Service oilChange = new Service("Ölwechsel", 0.5);
		Service tireChange = new Service("Reifenwechsel", 1.0);
		Service glassRepair = new Service("Glasreparatur", 2.0);
		Service inspectionCar = new Service("KFZ-Inspektion", 1.5);

		assertEquals(0.5, oilChange.getDurationInH());
		assertEquals(1.0, tireChange.getDurationInH());
		assertEquals(2.0, glassRepair.getDurationInH());
		assertEquals(1.5, inspectionCar.getDurationInH());

		assertEquals("Ölwechsel", oilChange.getName());
		assertEquals("Reifenwechsel", tireChange.getName());
		assertEquals("Glasreparatur", glassRepair.getName());
		assertEquals("KFZ-Inspektion", inspectionCar.getName());
	}
}
