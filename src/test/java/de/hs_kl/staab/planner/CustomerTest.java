package de.hs_kl.staab.planner;

import org.junit.jupiter.api.Test;

public class CustomerTest {

	@Test
	public void allServiceTest() {

		// // @formatter:off
		Customer customer1 = new Customer("Ammar Said", null, "+49176 258484750", "ammar@web.de");
		Customer customer2 = new Customer("Alexander Hermann", null, "0176-5656556", "alex@web.de");
		Customer customer3 = new Customer("Hendrik Treitz", null, "+49176-4548484", "hendrik@web.de");
	}
}