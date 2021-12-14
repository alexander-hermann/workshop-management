package de.hs_kl.staab.planner;

public class ConsultingAppointment extends Appointment {
	private final Customer customer;
	private final double durationInH;

	public ConsultingAppointment(int year, int month, int day, int hour, int minute, Customer customer,
			double durationInH) {
		super(year, month, day, hour, minute);
		this.customer = customer;
		this.durationInH = durationInH;
	}

	public Customer getCustomer() {
		return customer;
	}

	public double getDurationInH() {
		return durationInH;
	}

	@Override
	public String toString() {
		return "ConsultantAppointment [" + customer + ", DurationInH=" + durationInH + "]" + super.toString();
	}

}
