package de.hs_kl.staab.planner;

import java.util.ArrayList;
import java.util.List;

public class UserService {

	private List<User> listOfUsers = new ArrayList<>();

	// MMP/01

	// create a new user for the application

	public void createNewUser(User newUser) {
		if (!listOfUsers.contains(newUser)) {
			listOfUsers.add(newUser);
			System.out.println("The user " + newUser + "  was successfully added.");
		} else {
			throw new IllegalArgumentException(
					"The user cannot be added because the user " + newUser + " already exists in the list");
		}
	}

	public User getUserByUserName(String userName) {
		if (!listOfUsers.isEmpty()) {
			for (User user : listOfUsers) {
				if (user.getFullName().equals(userName)) {
					System.out.println(user);
					return user;
				}
			}
		} else {
			throw new IllegalArgumentException("The list of users is empty.");
		}
		throw new IllegalArgumentException(
				"The user with the user name " + userName + " does not exsit in the list for users");
	}

	public List<User> getUsers() {
		if (!listOfUsers.isEmpty()) {
			for (User user : listOfUsers) {
				System.out.println(user);
			}
			return listOfUsers;
		} else {
			throw new IllegalArgumentException("The list of users is empty.");
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

	public void getOverviewOfPlannedWorks(WorkingPlatform workingPlatform) {
		if (workingPlatform != null) {
			if (!workingPlatform.getListOfPlannedWorks().isEmpty()) {
				for (WorkingAppointment currentWorkingAppointment : workingPlatform.getListOfPlannedWorks()) {
					System.out.println(currentWorkingAppointment);
				}
			} else {
				System.err.println("The working platform " + workingPlatform.getId() + " has no planned works.");
			}
		} else {
			System.err.println("You have not entered a working platform.");
		}
	}

}
