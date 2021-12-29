package de.hs_kl.staab.planner;

public class User extends Person {

	protected static final String USER_PREFIX = "User-";
	protected static int USER_ID_COUNTER = 1;

	protected String idOfUser;
	protected String userName;

	public User(String fullName, String phoneNumber, String emailAddress) {
		super(fullName, phoneNumber, emailAddress);
		this.idOfUser = USER_PREFIX + USER_ID_COUNTER;
		USER_ID_COUNTER++;
	}

	public String getId() {
		return idOfUser;
	}

	public void setId(String newIdOfUser) {
		this.idOfUser = newIdOfUser;
	}

	public String getName() {
		return userName;
	}

	@Override
	public String toString() {
		return super.toString() + " userName=" + userName + "]";
	}
}