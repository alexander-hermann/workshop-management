package de.hs_kl.staab.planner;

public class Service {

	private final static String SERVICE_PREFIX = "SE-";
	private static int SERVICE_ID_COUNTER = 1;

	private String idOfService;
	private final String nameOfService;
	private final double durationOfServiceInH;

	public Service(String nameOfService, double durationOfServiceInH) {
		this.idOfService = SERVICE_PREFIX + SERVICE_ID_COUNTER;
		SERVICE_ID_COUNTER++;
		this.nameOfService = nameOfService;
		this.durationOfServiceInH = durationOfServiceInH;
	}

	public String getId() {
		return idOfService;
	}

	public void setId(String idOfService) {
		this.idOfService = idOfService;
	}

	public String getName() {
		return nameOfService;
	}

	public double getDurationInH() {
		return durationOfServiceInH;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Service [idOfService=");
		builder.append(idOfService);
		builder.append(", nameOfService=");
		builder.append(nameOfService);
		builder.append(", durationOfServiceInH=");
		builder.append(durationOfServiceInH);
		builder.append("]");
		return builder.toString();
	}
}