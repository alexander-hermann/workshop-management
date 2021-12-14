package de.hs_kl.staab.planner;

public class WorkingPlatform {

	private final static String WORKING_PLATFORM_PREFIX = "WKP-";
	private static int WORKING_PLATFORM_ID_COUNTER = 1;

	private String idOfWorkingPlatform;
	private final String nameOfWorkingPlatform;

	public WorkingPlatform(String nameOfWorkingPlatform) {
		this.idOfWorkingPlatform = WORKING_PLATFORM_PREFIX + WORKING_PLATFORM_ID_COUNTER;
		this.nameOfWorkingPlatform = nameOfWorkingPlatform;
	}

	public String getId() {
		return idOfWorkingPlatform;
	}

	public void setId(String idOfWorkingPlatform) {
		this.idOfWorkingPlatform = idOfWorkingPlatform;
	}

	public String getName() {
		return nameOfWorkingPlatform;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WorkingPlatform [idOfWorkingPlatform=");
		builder.append(idOfWorkingPlatform);
		builder.append(", nameOfWorkingPlatform=");
		builder.append(nameOfWorkingPlatform);
		builder.append("]");
		return builder.toString();
	}
}