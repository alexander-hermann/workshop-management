package de.hs_kl.staab.planner;

public class WorkingAppointment extends Appointment {
	private final WorkingPlatform workingPlatform;
	private final Vehicle vehicle;
	private final Service service;

	public WorkingAppointment(int year, int month, int day, int hour, int minute, WorkingPlatform workingPlatform,
			Vehicle vehicle, Service service) {
		super(year, month, day, hour, minute);
		this.workingPlatform = workingPlatform;
		this.vehicle = vehicle;
		this.service = service;
		this.endOfAppointment = this.startOfAppointment
				.plusMinutes((long) (service.getDurationInH() * TIME_CONVERSION_FAKTOR_IN_MINUTES));
	}

	public WorkingPlatform getWorkingPlatform() {
		return workingPlatform;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Service getService() {
		return service;
	}

	@Override
	public String toString() {
		return "WorkingAppointment [workingPlatform=" + workingPlatform + ", vehicle=" + vehicle + ", service="
				+ service + "]" + super.toString();
	}

}
