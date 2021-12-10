package de.hs_kl.staab.planner;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {

	private static final String CUSTOMER_PREFIX = "CS-";
	private static int CUSTOMER_ID_COUNTER = 1;
	private String customerId;

	private List<Vehicle> listOfVehiclesForCustomer = new ArrayList<>();

	public Customer(String fullName, Contact contactOfPerson, List<Vehicle> listOfVehicles) {
		super(fullName, contactOfPerson);

		this.customerId = CUSTOMER_PREFIX + CUSTOMER_ID_COUNTER;
		CUSTOMER_ID_COUNTER++;
		this.listOfVehiclesForCustomer.addAll(listOfVehicles);
	}

	@Override
	public String toString() {
		return super.toString() + ", customerId=" + customerId + ", listOfVehiclesForCustomer="
				+ listOfVehiclesForCustomer + "]";
	}

	public String getCustomerId() {
		return customerId;
	}

	public List<Vehicle> getListOfVehiclesForCustomer() {
		return listOfVehiclesForCustomer;
	}

	public Address getContact() {
		return contactOfPerson;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}
