
package de.hs_kl.staab.planner;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {

	private static final String CUSTOMER_PREFIX = "CS-";
	private static int CUSTOMER_ID_COUNTER = 1;
	private String customerId;
	private InvoiceAddress invoiceAddressOfPerson;
	private List<Vehicle> listOfVehiclesForCustomer;

	public Customer(String fullName, InvoiceAddress invoiceAddressOfPerson, String phoneNumber, String emailAddress) {
		super(fullName, phoneNumber, emailAddress);

		this.customerId = CUSTOMER_PREFIX + CUSTOMER_ID_COUNTER;
		CUSTOMER_ID_COUNTER++;
		this.invoiceAddressOfPerson = invoiceAddressOfPerson;

		this.listOfVehiclesForCustomer = new ArrayList<>();

	}

	@Override
	public String toString() {
		return super.toString() + " customerId=" + customerId + ", invoiceAddressOfPerson=" + invoiceAddressOfPerson
				+ "]";
	}

	public InvoiceAddress getInvoiceAddressOfPerson() {
		return invoiceAddressOfPerson;
	}

	public String getCustomerId() {
		return customerId;
	}

	public List<Vehicle> getListOfVehiclesForCustomer() {
		return listOfVehiclesForCustomer;
	}

	public void addVehicleToCustomer(Vehicle vehicle) {
		this.listOfVehiclesForCustomer.add(vehicle);
	}

	public void removeVehicleForCustomer(Vehicle vehicle) {
		this.listOfVehiclesForCustomer.remove(vehicle);
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

}
