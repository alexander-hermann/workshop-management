package de.hs_kl.staab.planner;

public class Workshop {

	private final static String TEXT_PREFIX = "WS-";
	private static int ID_COUNTER = 1;

	private final String idOfWorkshop;
	private final String nameOfWorkshop;
	private final Address addressOfWorkshop;

	public Workshop(String nameOfWorkshop, Address addressOfWorkshop) {
		this.idOfWorkshop = TEXT_PREFIX + ID_COUNTER;
		ID_COUNTER++;
		this.nameOfWorkshop = nameOfWorkshop;
		this.addressOfWorkshop = addressOfWorkshop;
	}
}
