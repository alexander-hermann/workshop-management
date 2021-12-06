package de.hs_kl.staab.planner;

public class Workshop {

	private final static String WORKSHOP_PREFIX = "WS-";
	private static int WORKSHOP_ID_COUNTER = 1;

	private final String idOfWorkshop;
	private final String nameOfWorkshop;
	private final Address addressOfWorkshop;

	public Workshop(String nameOfWorkshop, Address addressOfWorkshop) {
		this.idOfWorkshop = WORKSHOP_PREFIX + WORKSHOP_ID_COUNTER;
		WORKSHOP_ID_COUNTER++;
		this.nameOfWorkshop = nameOfWorkshop;
		this.addressOfWorkshop = addressOfWorkshop;
	}
}
