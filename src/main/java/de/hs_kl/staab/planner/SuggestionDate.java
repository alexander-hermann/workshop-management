package de.hs_kl.staab.planner;

import java.time.LocalDateTime;

public class SuggestionDate {

	private final LocalDateTime start;
	private final LocalDateTime end;

	public SuggestionDate(LocalDateTime start, LocalDateTime end) {
		this.start = start;
		this.end = end;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SuggestionDate [start=");
		builder.append(start);
		builder.append(", end=");
		builder.append(end);
		builder.append("]");
		return builder.toString();
	}
}