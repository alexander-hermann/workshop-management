package de.hs_kl.staab.planner;

import java.time.LocalDateTime;

public class ServiceHistory {
	private final Vehicle vehicle;
	private final Service service;
	private final User employee;
	private final LocalDateTime date;

	public ServiceHistory(Vehicle vehicle, Service service, User employee, LocalDateTime date) {
		super();
		this.vehicle = vehicle;
		this.service = service;
		this.employee = employee;
		this.date = date;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public Service getService() {
		return service;
	}

	public User getEmployee() {
		return employee;
	}

	public LocalDateTime getDate() {
		return date;
	}
}