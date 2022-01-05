package de.hs_kl.staab.planner;

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
		// this.dayOfAppointment = LocalDate.of(year, month, day);

		this.endOfAppointment = this.startOfAppointment
				.plusMinutes((long) (service.getDurationInH() * TIME_CONVERSION_FAKTOR_IN_MINUTES));

		this.vehicle.listOfWorkingAppointmentForVehicle.add(this);
		this.workingPlatform.addPlannedWork(this);
		this.carMechanic.listOfWorkingAppointmentForCarMechanic.add(this);
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

	public boolean isCompleted() {
		return isCompleted;

	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;

	}

	public CarMechanic getCarMechanic() {
		return carMechanic;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WorkingAppointment");
		builder.append(super.toString());
		builder.append(", [workingPlatform=");
		builder.append(workingPlatform);
		builder.append(", vehicle=");
		builder.append(vehicle);
		builder.append(", service=");
		builder.append(service);
		builder.append(", isCompleted=");
		builder.append(isCompleted);
		builder.append(", carMechanic=");
		builder.append(carMechanic);
		builder.append(", dayOfAppointment=");
		builder.append(dayOfAppointment);
		builder.append("]");
		return builder.toString();
	}
}