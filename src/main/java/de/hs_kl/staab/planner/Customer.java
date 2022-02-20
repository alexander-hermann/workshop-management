
package de.hs_kl.staab.planner;

public class Customer extends Person {

	private static final String CUSTOMER_PREFIX = "CS-";
	private static int CUSTOMER_ID_COUNTER = 1;
	private String customerId;
	private InvoiceAddress invoiceAddressOfPerson;

	public Customer(String fullName, InvoiceAddress invoiceAddressOfPerson, String phoneNumber, String emailAddress) {
		super(fullName, phoneNumber, emailAddress);

		this.customerId = CUSTOMER_PREFIX + CUSTOMER_ID_COUNTER;
		CUSTOMER_ID_COUNTER++;
		this.invoiceAddressOfPerson = invoiceAddressOfPerson;

	}

	public InvoiceAddress getInvoiceAddressOfPerson() {
		return invoiceAddressOfPerson;
	}

	public String getId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [customerId=");
		builder.append(customerId);
		builder.append(super.toString());
		builder.append(", invoiceAddressOfPerson=");
		builder.append(invoiceAddressOfPerson);
		builder.append("]");
		return builder.toString();
	}
}