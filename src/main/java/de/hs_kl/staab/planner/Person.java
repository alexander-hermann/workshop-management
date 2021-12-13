package de.hs_kl.staab.planner;

public abstract class Person {

	protected String fullName;
	protected Contact contactOfPerson;

	public Person(String fullName, Contact contactOfPerson) {
		this.fullName = fullName;
		this.contactOfPerson = contactOfPerson;
	}

	@Override
	public String toString() {
		return "Person [fullName=" + fullName + ", contact of person= " + contactOfPerson;
	}

	public String getFullName() {
		return fullName;
	}

	// If a person has changed the name (got married)

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Contact getContactOfPerson() {
		return contactOfPerson;
	}

// If a person has moved

	public void setContactOfPerson(Contact contactOfPerson) {
		this.contactOfPerson = contactOfPerson;
	}

	protected abstract Object getCustomerId();

}
