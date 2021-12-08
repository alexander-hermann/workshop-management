package de.hs_kl.staab.planner;

public abstract class Person {

	protected String fullName;
	protected Address addressOfPerson;

	public Person(String fullName, Address addressOfPerson) {
		this.fullName = fullName;
		this.addressOfPerson = addressOfPerson;
	}

	@Override
	public String toString() {
		return "Person [fullName=" + fullName + ", " + addressOfPerson;
	}

	public String getFullName() {
		return fullName;
	}

	// If a person has changed the name (got married)

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Address getAddressOfPerson() {
		return addressOfPerson;
	}

// If a person has moved

	public void setAddressOfPerson(Address addressOfPerson) {
		this.addressOfPerson = addressOfPerson;
	}

	protected abstract Object getCustomerId();

}
