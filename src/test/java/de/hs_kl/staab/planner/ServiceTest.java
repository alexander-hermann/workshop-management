package de.hs_kl.staab.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ServiceTest {

	@Test
	public void allServiceTest() {
		Service oilChange = new Service("Ölwechsel", 0.5);
		Service tireChange = new Service("Reifenwechsel", 1.0);
		Service glassRepair = new Service("Glasreparatur", 2.0);
		Service inspectionCar = new Service("KFZ-Inspektion", 1.5);

		assertEquals(oilChange.getId(), oilChange.getId());
		assertEquals(tireChange.getId(), tireChange.getId());
		assertEquals(tireChange.getId(), glassRepair.getId());
		assertEquals(inspectionCar.getId(), inspectionCar.getId());

		assertEquals(oilChange.getName(), oilChange.getName());
		assertEquals(tireChange.getName(), tireChange.getName());
		assertEquals(glassRepair.getName(), glassRepair.getName());
		assertEquals(inspectionCar.getName(), inspectionCar.getName());

		assertEquals(oilChange.getDurationInH(), oilChange.getDurationInH());
		assertEquals(tireChange.getDurationInH(), tireChange.getDurationInH());
		assertEquals(glassRepair.getDurationInH(), glassRepair.getDurationInH());
		assertEquals(inspectionCar.getDurationInH(), inspectionCar.getDurationInH());
	}
}
