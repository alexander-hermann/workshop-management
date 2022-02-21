package de.hs_kl.staab.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class WorkingPlatformTest {

	@Test
	public void allServiceTest() {
		WorkingPlatform wkp1 = new WorkingPlatform("Arbeitsbühne1");
		WorkingPlatform wkp2 = new WorkingPlatform("Arbeitsbühne2");
		WorkingPlatform wkp3 = new WorkingPlatform("Arbeitsbühne3");

		assertEquals(wkp1.getId(), wkp1.getId());
		assertEquals(wkp2.getId(), wkp2.getId());
		assertEquals(wkp3.getId(), wkp3.getId());

		assertEquals(wkp1.getName(), wkp1.getName());
		assertEquals(wkp2.getName(), wkp2.getName());
		assertEquals(wkp3.getName(), wkp3.getName());
	}
}