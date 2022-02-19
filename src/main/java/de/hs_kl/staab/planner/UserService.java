package de.hs_kl.staab.planner;

import java.util.ArrayList;
import java.util.List;

public class UserService {

	/**
	 * Singleton-Pattern: Der Konstruktor kann nicht aufgerufen werden, sondern
	 * {@link #getInstance()} muss aufgerufen werden. So kann sichergestellt werden,
	 * dass nur eine einzige Instanz dieser Klasse erstellt wird.
	 */

	private static UserService INSTANCE;

	private final PlanningCalendar planningCalendar;

	private UserService() {
		planningCalendar = new PlanningCalendar();
	}

	public static UserService getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new UserService();
		}
		return INSTANCE;
	}

	public PlanningCalendar getPlanningCalendar() {
		return planningCalendar;
	}

	private List<User> listOfUsers = new ArrayList<>();

	// MMP/01

	// create a new user for the application

	public void createNewUser(User newUser) {
		if (!listOfUsers.contains(newUser)) {

			listOfUsers.add(newUser);
			System.out.println("The user " + newUser + "  was successfully added.");
		} else {
			System.err.println("The user cannot be added because the user " + newUser + " already exists in the list");
		}
	}

	public void getUserByUserName(String userName) {
		if (!listOfUsers.isEmpty()) {
			for (User user : listOfUsers) {
				if (user.getId().equals(userName)) {
					System.out.println(user + " found.");

				}
			}
		} else {
			System.err.println("The list of users is empty.");
		}
		System.err.println("The user with the user name " + userName + " does not exsit in the list for users");
	}

	public List<User> getUsers() {
		if (!listOfUsers.isEmpty()) {
			for (User user : listOfUsers) {
				System.out.println(user);
			}
			return listOfUsers;
		} else {
			System.err.println("The list of users is empty.");
			return listOfUsers;
		}
	}

	// update a user when entering the username
	public void updateUser(User oldUser, User newUser) {
		List<User> listOfUpdatedUser = new ArrayList<>();

		if (!listOfUsers.isEmpty()) {
			for (User currentUser : listOfUsers) {
				if (currentUser.equals(oldUser)) {

					listOfUpdatedUser.add(currentUser);

					// Assigns the id of the old object to the new object
					newUser.setId(oldUser.getId());

					int indexOfOldUserInTheList = listOfUsers.indexOf(oldUser);
					listOfUsers.set(indexOfOldUserInTheList, newUser);
				}
			}
			if (listOfUpdatedUser.isEmpty()) {
				System.err.println("The user " + oldUser + " could not be found in the list");
			}
		} else {
			System.err.println("The user can't be updated because the list of users is empty.");
		}
	}

	public void removeUser(User removeUser) {
		if (!listOfUsers.isEmpty()) {
			if (listOfUsers.contains(removeUser)) {
				listOfUsers.remove(removeUser);
				System.out.println("The user " + removeUser.getId() + " was successfully deleted.");
			} else {
				System.err.println("The user could not be deleted because the object was not found in the list.");
			}
		} else {
			System.err.println("The user can't be deleted because the list of users is empty.");
		}
	}
}