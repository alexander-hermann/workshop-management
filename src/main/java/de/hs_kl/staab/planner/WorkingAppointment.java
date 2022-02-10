package de.hs_kl.staab.planner;

import java.util.List;

public class WorkingAppointment extends Appointment {
	private final WorkingPlatform workingPlatform;
	private final Vehicle vehicle;
	private final List<Service> collectionOfWork;
	private boolean isCompleted;
	private final CarMechanic carMechanic;

	public WorkingAppointment(int year, int month, int day, int hour, int minute, WorkingPlatform workingPlatform,
			Vehicle vehicle, List<Service> collectionOfWork, CarMechanic carMechanic) {
		super(year, month, day, hour, minute);
		this.workingPlatform = workingPlatform;
		this.vehicle = vehicle;
		this.collectionOfWork = collectionOfWork;
		this.isCompleted = false;
		this.carMechanic = carMechanic;

		double total = collectionOfWork.stream().mapToDouble(Service::getDurationInH).sum();

		this.endOfAppointment = this.startOfAppointment.plusMinutes((long) (total * TIME_CONVERSION_FAKTOR_IN_MINUTES));

		this.vehicle.listOfWorkingAppointmentForVehicle.add(this);
		this.carMechanic.listOfWorkingAppointmentForCarMechanic.add(this);
	}

	@Override
	public WorkingPlatform getWorkingPlatform() {
		return workingPlatform;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public List<Service> getService() {
		return collectionOfWork;
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
		builder.append(", collectionOfWork=");
		builder.append(collectionOfWork);
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