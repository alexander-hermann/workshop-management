package de.hs_kl.staab.planner;

import java.util.ArrayList;
import java.util.List;

public class WorkingPlatform {

	private final static String WORKING_PLATFORM_PREFIX = "WKP-";
	private static int WORKING_PLATFORM_ID_COUNTER = 1;

	private String idOfWorkingPlatform;
	private final String nameOfWorkingPlatform;
	private List<WorkingAppointment> listOfPlannedWorks;

	public WorkingPlatform(String nameOfWorkingPlatform) {
		this.idOfWorkingPlatform = WORKING_PLATFORM_PREFIX + WORKING_PLATFORM_ID_COUNTER;
		WORKING_PLATFORM_ID_COUNTER++;
		this.nameOfWorkingPlatform = nameOfWorkingPlatform;

		this.listOfPlannedWorks = new ArrayList<>();
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

	public List<WorkingAppointment> getListOfPlannedWorks() {
		return listOfPlannedWorks;
	}

	public void addPlannedWork(WorkingAppointment workingAppointment) {
		this.listOfPlannedWorks.add(workingAppointment);
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