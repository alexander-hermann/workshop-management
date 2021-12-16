package de.hs_kl.staab.planner;

public class User extends Person {

	protected static final String USER_PREFIX = "user";
	protected static int USER_COUNTER = 1;
	protected String userName;

	public User(String fullName, String phoneNumber, String emailAddress) {
		super(fullName, phoneNumber, emailAddress);
		this.userName = USER_PREFIX + USER_COUNTER;
		USER_COUNTER++;
	}

	@Override
	public String toString() {
		return super.toString() + " userName=" + userName + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
