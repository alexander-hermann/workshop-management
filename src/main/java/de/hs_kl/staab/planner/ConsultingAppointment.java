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

		this.endOfAppointment = this.startOfAppointment.plusHours((long) this.durationInH);
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
		return "ConsultingAppointment [customer=" + customer + ", durationInH=" + durationInH + ", customerConsultant="
				+ customerConsultant + "]";
	}

}
