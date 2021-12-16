package de.hs_kl.staab.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class WorkingPlatformTest {

	@Test
	public void allServiceTest() {
		WorkingPlatform wkp1 = new WorkingPlatform("Arbeitsbühne1");
		WorkingPlatform wkp2 = new WorkingPlatform("Arbeitsbühne2");
		WorkingPlatform wkp3 = new WorkingPlatform("Arbeitsbühne3");

		assertEquals("WKP-1", wkp1.getId());
		assertEquals("WKP-2", wkp2.getId());
		assertEquals("WKP-3", wkp3.getId());

		assertEquals("Arbeitsbühne1", wkp1.getName());
		assertEquals("Arbeitsbühne2", wkp2.getName());
		assertEquals("Arbeitsbühne3", wkp3.getName());
	}
}