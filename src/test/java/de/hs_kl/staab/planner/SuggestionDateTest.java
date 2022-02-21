package de.hs_kl.staab.planner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class SuggestionDateTest {

	@Test
	public void allSuggestionDateTest() {

		SuggestionDate suggestionDate1 = new SuggestionDate(LocalDateTime.of(2022, 2, 20, 12, 10),
				LocalDateTime.of(2022, 2, 22, 12, 30));

		assertEquals(suggestionDate1.getStart(), suggestionDate1.getStart());
		assertEquals(suggestionDate1.getEnd(), suggestionDate1.getEnd());
	}
}