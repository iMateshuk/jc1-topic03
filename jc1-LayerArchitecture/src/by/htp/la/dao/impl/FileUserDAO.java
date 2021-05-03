package by.htp.la.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import by.htp.la.bean.User;
import by.htp.la.dao.UserDAO;
import by.htp.la.dao.exception.DAOException;
import by.htp.la.util.Path;
import by.htp.la.util.UserCreator;

public class FileUserDAO implements UserDAO {

	private final String delimeter = ":";

	@Override
	public String signIn(String login, String password) throws DAOException {
		// TODO Auto-generated method stub

		String readeLine;
		String[] lineData;
		String response = null;

		try (BufferedReader br = new BufferedReader(new FileReader(Path.USER_RESOURCE.getPath()))) {

			while ((readeLine = br.readLine()) != null) {

				lineData = readeLine.split(delimeter);

				if (lineData.length >= 2) {

					if (lineData[0].compareTo(login) == 0 && lineData[1].compareTo(password) == 0) {

						response = readeLine;
						break;
					}

				}

			}

			if (response == null) {

				throw new DAOException("Error. User not found.");
			}

			return response;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}

	}

	@Override
	public void registrationUser(User user) throws DAOException {
		// TODO Auto-generated method stub

		try {

			List<User> users = getUsers();

			int usersSize = users.size();

			users = userIn(users, user);

			if (usersSize - users.size() > 0) {

				throw new DAOException("Error. User exist in file.");

			}

			writeUsers(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}
	}

	@Override
	public void deleteUser(User user) throws DAOException {
		// TODO Auto-generated method stub

		try {

			List<User> users = getUsers();

			int usersSize = users.size();

			users = userIn(users, user);

			if (!(usersSize - users.size() > 0)) {

				throw new DAOException("Error. User not in file.");

			}

			File recourceFile = new File(Path.USER_RESOURCE.getPath());

			if (!recourceFile.delete()) {

				throw new DAOException("Error. File not delete.");
			}

			writeUsers(users.toArray(new User[users.size()]));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}

	}

	/////////////////////////////////////////////

	private void writeUsers(User... users) throws IOException {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(Path.USER_RESOURCE.getPath(), true))) {

			for (User user : users) {

				bw.write(user.inString());
				bw.newLine();
				bw.flush();
			}

		} catch (IOException e) {

			throw new IOException(e);
		}
	}

	private List<User> getUsers() throws IOException {

		List<User> users = new ArrayList<>();
		String readeLine;

		try (BufferedReader br = new BufferedReader(new FileReader(Path.USER_RESOURCE.getPath()))) {

			while ((readeLine = br.readLine()) != null) {

				if (!(readeLine.isBlank() || readeLine.isEmpty())) {

					users.add(UserCreator.createUser(readeLine.split(delimeter)));
				}
			}

		} catch (IOException e) {

			throw new IOException(e);
		}

		return users;
	}

	private List<User> userIn(List<User> users, User user) {

		Iterator<User> userIterator = users.iterator();

		User checkUser;

		while (userIterator.hasNext()) {

			checkUser = userIterator.next();

			// if (userComparator.compare(checkUser, user) == 0) {
			if (checkUser.getLogin().compareTo(user.getLogin()) == 0) {

				userIterator.remove();
			}

		}

		return users;
	}

}
