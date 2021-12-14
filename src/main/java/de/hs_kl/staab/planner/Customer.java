package de.hs_kl.staab.planner;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {

	private static final String CUSTOMER_PREFIX = "CS-";
	private static int CUSTOMER_ID_COUNTER = 1;
	private String customerId;
	private Contact contactOfPerson;

	private List<Vehicle> listOfVehiclesForCustomer = new ArrayList<>();

	public Customer(String fullName, Contact contactOfPerson, List<Vehicle> listOfVehicles) {
		super(fullName);

		this.customerId = CUSTOMER_PREFIX + CUSTOMER_ID_COUNTER;
		CUSTOMER_ID_COUNTER++;
		this.contactOfPerson = contactOfPerson;
		this.listOfVehiclesForCustomer.addAll(listOfVehicles);

	}

	@Override
	public String toString() {
		return super.toString() + " customerId=" + customerId + ", contactOfPerson=" + contactOfPerson
				+ ", listOfVehiclesForCustomer=" + listOfVehiclesForCustomer + "]";
	}

	public Contact getContactOfPerson() {
		return contactOfPerson;
	}

	public void setListOfVehiclesForCustomer(List<Vehicle> listOfVehiclesForCustomer) {
		this.listOfVehiclesForCustomer = listOfVehiclesForCustomer;
	}

	public String getCustomerId() {
		return customerId;
	}

	public List<Vehicle> getListOfVehiclesForCustomer() {
		return listOfVehiclesForCustomer;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}
