package de.hs_kl.staab.planner;

public class Contact {
	private final String streetName;
	private final int streetNumber;
	private final int zipCode;
	private final String city;
	private final int phoneNumber;
	private final String emailAddress;

	public Contact(String streetName, int streetNumber, int zipCode, String city, int phoneNumber,
			String emailAddress) {
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.zipCode = zipCode;

		this.city = city;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
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

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public String emailAddress() {
		return emailAddress;
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