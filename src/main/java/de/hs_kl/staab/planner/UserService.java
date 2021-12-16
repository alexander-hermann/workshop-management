package de.hs_kl.staab.planner;

import java.util.ArrayList;
import java.util.List;

public class UserService {

	private List<User> listOfUsers = new ArrayList<>();

	public void createNewUser(User newUser) {
		if (!listOfUsers.contains(newUser)) {
			listOfUsers.add(newUser);
			System.out.println("The user " + newUser + "  was successfully added.");
		} else {
			throw new IllegalArgumentException("The user cannot be added because it already exists in the list");
		}
	}

	public void updateUser(String userName, User newUser) {
		if (!listOfUsers.isEmpty()) {
			List<User> listOfUpdatedUser = new ArrayList<>();
			for (User user : listOfUsers) {
				if (user.userName.equals(newUser.getUserName())) {
					listOfUpdatedUser.add(user);

					// Assigns the id of the old object to the new object

					newUser.setUserName(user.getUserName());
					listOfUsers.set(listOfUsers.indexOf(user), newUser);
				}
			}
			if (listOfUpdatedUser.isEmpty()) {
				throw new IllegalArgumentException(
						"The userName " + userName + " does not exist in the list for users");
			}

		} else {
			throw new IllegalArgumentException("The user cannot be updated because the list of users is empty.");
		}
	}

	public User getUsers() {
		if (!listOfUsers.isEmpty()) {
			for (User user : listOfUsers) {
				System.out.println(user);
				return user;
			}
		} else {
			throw new IllegalArgumentException("The list of users is empty.");
		}
		throw new IllegalArgumentException("Error with user");
	}

	public User getUserByUserName(String userName) {
		if (!listOfUsers.isEmpty()) {
			for (User user : listOfUsers) {
				if (user.getUserName().equals(userName)) {
					System.out.println(user);
					return user;
				}

			}
		} else {
			throw new IllegalArgumentException("The list of users is empty.");
		}
		throw new IllegalArgumentException("Error with user");
	}

}
