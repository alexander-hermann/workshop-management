package de.hs_kl.staab.planner;

public abstract class Person {

	protected String fullName;

	public Person(String fullName) {
		this.fullName = fullName;

	}

	@Override
	public String toString() {
		return "Person [fullName=" + fullName + ", ";
	}

	public String getFullName() {
		return fullName;
	}

	// If a person has changed the name (got married)

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	protected abstract Object getCustomerId();

}
