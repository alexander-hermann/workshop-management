package de.hs_kl.staab.planner;

public class WorkingPlatform {

	private final static String WORKING_PLATFORM_PREFIX = "WKP-";
	private static int WORKING_PLATFORM_ID_COUNTER = 1;

	private final String idOfWorkingPlatform;
	private final String nameOfWorkingPlatform;
	private boolean isWorkingPlatformAvailable;
	private Workshop workshop;

	public WorkingPlatform(String nameOfWorkingPlatform, boolean isWorkingPlatformAvailable, Workshop workshop) {
		this.idOfWorkingPlatform = WORKING_PLATFORM_PREFIX + WORKING_PLATFORM_ID_COUNTER;
		WORKING_PLATFORM_ID_COUNTER++;
		this.nameOfWorkingPlatform = nameOfWorkingPlatform;
		this.isWorkingPlatformAvailable = isWorkingPlatformAvailable;
		this.workshop = workshop;
	}

	public boolean isWorkingPlatformAvailable() {
		return isWorkingPlatformAvailable;
	}

	public void setWorkingPlatformAvailable(boolean isWorkingPlatformAvailable) {
		this.isWorkingPlatformAvailable = isWorkingPlatformAvailable;
	}

	public Workshop getWorkshop() {
		return workshop;
	}

	public void setWorkshop(Workshop workshop) {
		this.workshop = workshop;
	}

	public String getIdOfWorkingPlatform() {
		return idOfWorkingPlatform;
	}

	public String getNameOfWorkingPlatform() {
		return nameOfWorkingPlatform;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WorkingPlatform [idOfWorkingPlatform=");
		builder.append(idOfWorkingPlatform);
		builder.append(", nameOfWorkingPlatform=");
		builder.append(nameOfWorkingPlatform);
		builder.append(", isWorkingPlatformAvailable=");
		builder.append(isWorkingPlatformAvailable);
		builder.append(", workshop=");
		builder.append(workshop);
		builder.append("]");
		return builder.toString();
	}
}