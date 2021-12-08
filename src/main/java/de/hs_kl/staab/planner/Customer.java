package de.hs_kl.staab.planner;

import java.util.ArrayList;

public class Customer extends Person {

	private static final String CUSTOMER_PREFIX = "CS-";
	private static int CUSTOMER_ID_COUNTER = 1;
	private String customerId;
	private String receiptData;
	private String contactDetails;
	private ArrayList<Person> listOfCustomers;
	private ArrayList<Vehicle> listOfVehiclesForCustomer;

	public Customer(String fullName, Address addressOfPerson, String receiptData, String contactDetails) {
		super(fullName, addressOfPerson);

		this.customerId = CUSTOMER_PREFIX + CUSTOMER_ID_COUNTER;
		CUSTOMER_ID_COUNTER++;
		this.receiptData = receiptData;
		this.contactDetails = contactDetails;

	}

	public void createNewCustomer(Customer customer) {
		listOfCustomers = new ArrayList<>();
		listOfCustomers.add(customer);
	}

	public void updateCustomer(Customer customer) {
		this.receiptData = customer.receiptData;
		this.fullName = customer.fullName;
		this.contactDetails = customer.contactDetails;
		this.addressOfPerson = customer.addressOfPerson;

	}

	@Override
	public String toString() {
		return super.toString() + ", customerId=" + customerId + ", receiptData=" + receiptData + ", contactDetails="
				+ contactDetails + ", listOfCustomers=" + listOfCustomers + ", listOfVehiclesForCustomer="
				+ listOfVehiclesForCustomer + "]";
	}

	public String getReceiptData() {
		return receiptData;
	}

	public void setReceiptData(String receiptData) {
		this.receiptData = receiptData;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getCustomerId() {
		return customerId;
	}

	public ArrayList<Person> getListOfCustomers() {
		return listOfCustomers;
	}

	public ArrayList getListOfVehiclesForCustomer() {
		return listOfVehiclesForCustomer;
	}

}
