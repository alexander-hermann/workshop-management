/**
 * @author Alexander Hermann
 */
package de.hs_kl.staab.planner;

import java.util.ArrayList;
import java.util.List;

public class Service {

	private final static String SERVICE_PREFIX = "SE-";
	private static int SERVICE_ID_COUNTER = 1;

	private String idOfService;
	private final String nameOfService;
	private final double durationOfServiceInH;

	private static List<Service> listOfServices = new ArrayList<>();

	public Service(String nameOfService, double durationOfServiceInH) {
		this.idOfService = SERVICE_PREFIX + SERVICE_ID_COUNTER;
		SERVICE_ID_COUNTER++;
		this.nameOfService = nameOfService;
		this.durationOfServiceInH = durationOfServiceInH;
	}

	public String getId() {
		return idOfService;
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

	public static Service getServiceById(int serviceId) {
		String addPrefixtoId = SERVICE_PREFIX + serviceId;
		if (!listOfServices.isEmpty()) {
			for (Service service : listOfServices) {
				if (service.getId().equals(addPrefixtoId)) {
					return service;
				}
			}
		} else {
			throw new IllegalArgumentException("The list of services is empty.");
		}
		throw new IllegalArgumentException("The service with the id " + serviceId + " was not found.");
	}

	public static void getServices() {
		if (!listOfServices.isEmpty()) {
			for (Service service : listOfServices) {
				System.out.println(service);
			}
		} else {
			throw new IllegalArgumentException("The list of services is empty.");
		}
	}

	public static void createNewService(Service newService) {
		listOfServices.add(newService);
		System.out.println("The service " + newService.getId() + "  was successfully added.");
	}

	public void updateService(Service updateService) {
		if (!listOfServices.isEmpty()) {
			for (Service service : listOfServices) {
				if (service.equals(this)) {
					// New object gets the id from the old object
					updateService.idOfService = this.idOfService;
					listOfServices.set(listOfServices.indexOf(this), updateService);

					System.out.println("Old object: " + service);
					System.out.println("New object: " + updateService);
				}
			}
		} else {
			throw new IllegalArgumentException(
					"The service " + this.getId() + " can not be updated, because the list of services is empty.");
		}
	}

	public static void removeService(Service removeService) {
		if (!listOfServices.isEmpty()) {
			listOfServices.remove(removeService);
			System.out.println("The service " + removeService.getId() + "  was successfully deleted.");
		} else {
			throw new IllegalArgumentException("The service " + removeService.getId()
					+ " can't be deleted, because the list of services is empty.");
		}
	}
}
