package de.hs_kl.staab.planner;

public class Contact {
	private final String streetName;
	private final int streetNumber;
	private final int zipCode;
	private final String city;

	public Contact(String streetName, int streetNumber, int zipCode, String city) {
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [streetName=");
		builder.append(streetName);
		builder.append(", streetNumber=");
		builder.append(streetNumber);
		builder.append(", zipCode=");
		builder.append(zipCode);
		builder.append(", city=");
		builder.append(city);
		builder.append("]");
		return builder.toString();
	}
}