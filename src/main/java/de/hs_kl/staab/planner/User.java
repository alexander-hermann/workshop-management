package de.hs_kl.staab.planner;

public class User extends Person {

	protected static final String USER_PREFIX = "User-";
	protected static int USER_ID_COUNTER = 1;

	protected String idOfUser;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [idOfUser=");
		builder.append(idOfUser);
		builder.append("]");
		return builder.toString();
	}
}