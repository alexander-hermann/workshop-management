/**
 * @author Alexander Hermann
 */
package de.hs_kl.staab.planner;

import java.util.ArrayList;
import java.util.List;

public class WorkingPlatform {

	private final static String WORKING_PLATFORM_PREFIX = "WKP-";
	private static int WORKING_PLATFORM_ID_COUNTER = 1;

	private String idOfWorkingPlatform;
	private final String nameOfWorkingPlatform;

	private static List<WorkingPlatform> listOfWorkingPlatforms = new ArrayList<>();

	public WorkingPlatform(String nameOfWorkingPlatform) {
		this.idOfWorkingPlatform = WORKING_PLATFORM_PREFIX + WORKING_PLATFORM_ID_COUNTER;
		WORKING_PLATFORM_ID_COUNTER++;
		this.nameOfWorkingPlatform = nameOfWorkingPlatform;
	}

	public String getId() {
		return idOfWorkingPlatform;
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

	public static WorkingPlatform getWorkingPlatformById(int workingPlatformId) {
		String addPrefixtoId = WORKING_PLATFORM_PREFIX + workingPlatformId;
		if (!listOfWorkingPlatforms.isEmpty()) {
			for (WorkingPlatform workingPlatform : listOfWorkingPlatforms) {
				if (workingPlatform.getId().equals(addPrefixtoId)) {
					return workingPlatform;
				}
			}
		} else {
			throw new IllegalArgumentException("The list of workingplatform is empty.");
		}
		throw new IllegalArgumentException("The workingplatform with the id " + workingPlatformId + " was not found.");
	}

	public static void getWorkingPlatforms() {
		if (!listOfWorkingPlatforms.isEmpty()) {
			for (WorkingPlatform workingPlatform : listOfWorkingPlatforms) {
				System.out.println(workingPlatform);
			}
		} else {
			throw new IllegalArgumentException("The list of workingplatforms is empty.");
		}
	}

	public static void createNewWorkingPlatform(WorkingPlatform newWorkingPlatform) {
		listOfWorkingPlatforms.add(newWorkingPlatform);
		System.out.println("The workingplatform " + newWorkingPlatform.getId() + "  was successfully added.");
	}

	public void updateWorkingPlatform(WorkingPlatform updateWorkingPlatform) {
		if (!listOfWorkingPlatforms.isEmpty()) {
			for (WorkingPlatform workingPlatform : listOfWorkingPlatforms) {
				if (workingPlatform.equals(this)) {
					// New object gets the id from the old object
					updateWorkingPlatform.idOfWorkingPlatform = this.idOfWorkingPlatform;

					System.out.println("Old object: " + workingPlatform);
					listOfWorkingPlatforms.set(listOfWorkingPlatforms.indexOf(this), updateWorkingPlatform);
					System.out.println("New object: " + updateWorkingPlatform);
				}
			}
		} else {
			throw new IllegalArgumentException(
					"The workingplatform " + this.getId() + " can not be updated, because the list is empty.");
		}
	}

	public static void removeWorkingPlatform(WorkingPlatform removeWorkingPlatform) {
		if (!listOfWorkingPlatforms.isEmpty()) {
			listOfWorkingPlatforms.remove(removeWorkingPlatform);
			System.out.println("The workingplatform " + removeWorkingPlatform.getId() + "  was successfully deleted.");

		} else {
			throw new IllegalArgumentException("The workingplatform " + removeWorkingPlatform.getId()
					+ " can't be deleted, because the list of workingplatform is empty.");
		}
	}
}