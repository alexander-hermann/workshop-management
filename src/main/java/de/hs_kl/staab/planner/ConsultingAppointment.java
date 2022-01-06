package de.hs_kl.staab.planner;

public class ConsultingAppointment extends Appointment {
	private final Customer customer;
	private final double durationInH;
	private final CustomerConsultant customerConsultant;

	public ConsultingAppointment(int year, int month, int day, int hour, int minute, Customer customer,
			double durationInH, CustomerConsultant customerConsultant) {
		super(year, month, day, hour, minute);
		this.customer = customer;
		this.durationInH = durationInH;
		this.customerConsultant = customerConsultant;

		this.endOfAppointment = this.startOfAppointment
				.plusMinutes((long) (this.durationInH * TIME_CONVERSION_FAKTOR_IN_MINUTES));
	}

	public CustomerConsultant getCustomerConsultant() {
		return customerConsultant;
	}

	public Customer getCustomer() {
		return customer;
	}

	public double getDurationInH() {
		return durationInH;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConsultingAppointment");
		builder.append(super.toString());
		builder.append(", [customer=");
		builder.append(customer);
		builder.append(", durationInH=");
		builder.append(durationInH);
		builder.append(", customerConsultant=");
		builder.append(customerConsultant);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public WorkingPlatform getWorkingPlatform() {
		// TODO Auto-generated method stub
		return null;
	}

}