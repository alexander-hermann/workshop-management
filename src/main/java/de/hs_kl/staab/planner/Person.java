package de.hs_kl.staab.planner;

public abstract class Person {

	protected String fullName;
	protected final String phoneNumber;
	protected final String emailAddress;

	public Person(String fullName, String phoneNumber, String emailAddress) {
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;

	}

	public String getFullName() {
		return fullName;
	}

	// If a person has changed the name (got married)
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [fullName=");
		builder.append(fullName);
		builder.append(", phoneNumber=");
		builder.append(phoneNumber);
		builder.append(", emailAddress=");
		builder.append(emailAddress);
		builder.append("]");
		return builder.toString();
	}
}