package de.hs_kl.staab.planner;

public class WorkingPlatform {

	private final static String WORKING_PLATFORM_PREFIX = "WKP-";
	private static int WORKING_PLATFORM_ID_COUNTER = 1;

	private final String idOfWorkingPlatform;
	private final String nameOfWorkingPlatform;
	private boolean isWorkingPlatformAvailable;
	private Workshop workshop;

}
