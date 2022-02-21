package de.hs_kl.staab.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DispatcherTest {

	@Test
	public void allDispatcherTest() {

		Dispatcher dispatcher1 = new Dispatcher("Disponent-1", "1232567890", "Herbert@ATU.de");

		assertEquals(dispatcher1.getId(), dispatcher1.getId());
		assertEquals(dispatcher1.getFullName(), dispatcher1.getFullName());
		assertEquals(dispatcher1.getEmailAddress(), dispatcher1.getEmailAddress());
		assertEquals(dispatcher1.getPhoneNumber(), dispatcher1.getPhoneNumber());
	}
}