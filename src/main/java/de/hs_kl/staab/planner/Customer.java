package de.hs_kl.staab.planner;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {

	private static final String CUSTOMER_PREFIX = "CS-";
	private static int CUSTOMER_ID_COUNTER = 1;
	private String customerId;
	private InvoiceAddress invoiceAddressOfPerson;

	private List<Vehicle> listOfVehiclesForCustomer = new ArrayList<>();

	public Customer(String fullName, InvoiceAddress invoiceAddressOfPerson, String phoneNumber, String emailAddress,
			List<Vehicle> listOfVehicles) {
		super(fullName, phoneNumber, emailAddress);

		this.customerId = CUSTOMER_PREFIX + CUSTOMER_ID_COUNTER;
		CUSTOMER_ID_COUNTER++;
		this.invoiceAddressOfPerson = invoiceAddressOfPerson;
		this.listOfVehiclesForCustomer.addAll(listOfVehicles);

	}

	@Override
	public String toString() {
		return super.toString() + " customerId=" + customerId + ", invoiceAddressOfPerson=" + invoiceAddressOfPerson
				+ ", listOfVehiclesForCustomer=" + listOfVehiclesForCustomer + "]";
	}

	public InvoiceAddress getInvoiceAddressOfPerson() {
		return invoiceAddressOfPerson;
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
