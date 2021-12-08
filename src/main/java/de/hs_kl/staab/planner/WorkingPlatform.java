package de.hs_kl.staab.planner;

import java.util.ArrayList;

public class WorkingPlatform {

	private final static String WORKING_PLATFORM_PREFIX = "WKP-";
	private static int WORKING_PLATFORM_ID_COUNTER = 1;

	private final String idOfWorkingPlatform;
	private final String nameOfWorkingPlatform;

	private ArrayList<WorkingPlatform> listOfWorkingPlatforms;

	public WorkingPlatform(String nameOfWorkingPlatform) {
		this.idOfWorkingPlatform = WORKING_PLATFORM_PREFIX + WORKING_PLATFORM_ID_COUNTER;
		this.nameOfWorkingPlatform = nameOfWorkingPlatform;
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
		builder.append("]");
		return builder.toString();
	}

	public ArrayList<WorkingPlatform> getWorkingPlatforms() {
		return listOfWorkingPlatforms;
	}

	public void createNewWorkingPlatform(WorkingPlatform workingPlatform) {
		listOfWorkingPlatforms = new ArrayList<>();
		listOfWorkingPlatforms.add(workingPlatform);
	}
}