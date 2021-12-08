package de.hs_kl.staab.planner;

import java.util.ArrayList;

public class Service {

	private final static String SERVICE_PREFIX = "SE-";
	private static int SERVICE_ID_COUNTER = 1;

	private final String idOfService;
	private final String nameOfService;
	private final double durationOfServiceInH;

	private static ArrayList<Service> listOfServices = new ArrayList<>();

	public Service(String nameOfService, double durationOfServiceInH) {
		this.idOfService = SERVICE_PREFIX + SERVICE_ID_COUNTER;
		SERVICE_ID_COUNTER++;
		this.nameOfService = nameOfService;
		this.durationOfServiceInH = durationOfServiceInH;
	}

	public static void createNewService(Service newService) {
		listOfServices.add(newService);
		System.out.println("Erfolgreich");
	}

	public static Service getServiceById(int serviceId) {
		String test = SERVICE_PREFIX + serviceId;
		for (Service service : listOfServices) {
			if (service.getIdOfService().equals(test)) {
				System.out.println("Gefunden");
				return service;
			}
		}
		System.out.println("Nichts gefunden");
		return null;
		// continue
	}

	public static ArrayList<Service> getListOfServices() {
		return listOfServices;
	}

	public String getIdOfService() {
		return idOfService;
	}

}
