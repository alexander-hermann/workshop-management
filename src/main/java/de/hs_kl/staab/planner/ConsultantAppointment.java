package de.hs_kl.staab.planner;

public class ConsultantAppointment extends Appointment {
	Customer customer;
	double DurationInH;

	public ConsultantAppointment(int year, int month, int day, int hour, int minute, Customer customer,
			double DurationInH) {
		super(year, month, day, hour, minute);
		this.customer = customer;
		this.DurationInH = DurationInH;

		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ConsultantAppointment [" + customer + ", DurationInH=" + DurationInH + "]" + super.toString();
	}

}
