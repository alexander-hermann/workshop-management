package de.hs_kl.staab.planner;

import java.time.LocalDateTime;

public class WorkingAppointment extends Appointment {
	private final WorkingPlatform workingPlatform;
	private final Vehicle vehicle;
	private final Service service;
	private boolean isCompleted;
	private final CarMechanic carMechanic;

	public WorkingAppointment(int year, int month, int day, int hour, int minute, WorkingPlatform workingPlatform,
			Vehicle vehicle, Service service, CarMechanic carMechanic) {
		super(year, month, day, hour, minute);
		this.workingPlatform = workingPlatform;
		this.vehicle = vehicle;
		this.service = service;
		this.isCompleted = false;
		this.carMechanic = carMechanic;
		this.endOfAppointment = this.startOfAppointment
				.plusMinutes((long) (service.getDurationInH() * TIME_CONVERSION_FAKTOR_IN_MINUTES));
		this.vehicle.listOfWorkingAppointmentForVehicle.add(this);
	}

	public CarMechanic getCarMechanic() {
		return carMechanic;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public boolean isCompleted() {
		return isCompleted;
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

	public LocalDateTime getStartOfAppointment() {
		return startOfAppointment;
	}

	@Override
	public String toString() {
		return "WorkingAppointment [workingPlatform=" + workingPlatform + ", vehicle=" + vehicle + ", service="
				+ service + ", isCompleted=" + isCompleted + ", carMechanic=" + carMechanic + "]";
	}

}
