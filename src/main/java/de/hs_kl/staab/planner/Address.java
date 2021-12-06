package de.hs_kl.staab.planner;

public class Address {

	private final String streetName;
	private final int streetNumber;
	private final int zipCode;
	private final String city;

	public Address(String streetName, int streetNumber, int zipCode, String city) {
		super();
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.zipCode = zipCode;
		this.city = city;
	}

	public String getStreetName() {
		return streetName;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public int getZipCode() {
		return zipCode;
	}

	public String getCity() {
		return city;
	}
}