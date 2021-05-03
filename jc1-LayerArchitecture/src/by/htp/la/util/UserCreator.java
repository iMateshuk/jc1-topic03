package by.htp.la.util;

import by.htp.la.bean.User;

public class UserCreator {

	public static User createUser(String[] userData) {
		User user;

		if (userData.length == 2) {

			user = new User.UserBuilder(userData[0], userData[1]).build();

		} else if (userData.length == 3) {

			user = new User.UserBuilder(userData[0], userData[1]).setAdult(userData[2].equals("true")).build();

		} else {

			user = new User.UserBuilder(userData[0], userData[1]).setAdult(userData[2].equals("true"))
					.setAdmin(userData[3].equals("true")).build();

		}

		return user;

	}

}
