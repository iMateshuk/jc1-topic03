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

public class FileUserDAO implements UserDAO {

	private final String RESOURCE = "resource\\userData.txt";
	private final String delimeter = ":";

	@Override
	public String signIn(String login, String password) throws DAOException {
		// TODO Auto-generated method stub

		String readeLine;
		String[] strings;

		try (BufferedReader br = new BufferedReader(new FileReader(RESOURCE))) {

			while ((readeLine = br.readLine()) != null) {

				strings = readeLine.split(delimeter);

				if (strings.length >= 2) {

					if (strings[0].compareTo(login) == 0 && strings[1].compareTo(password) == 0) {

						return readeLine;
					}

				}

			}

			throw new DAOException("Error. DAOsignIn. Login or passowrd incorrect.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}

	}

	@Override
	public void registrationUser(User user) throws DAOException {
		// TODO Auto-generated method stub

		String readeLine;

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(RESOURCE, true));
				BufferedReader br = new BufferedReader(new FileReader(RESOURCE))) {

			while ((readeLine = br.readLine()) != null) {

				if (!readeLine.isBlank() && !readeLine.isEmpty()) {
					if (user.getLogin().equals(readeLine.substring(0, readeLine.indexOf(delimeter)))) {

						throw new DAOException("Error. User exist!");
					}
				}
			}

			bw.newLine();
			bw.write(user.getLogin() + ":" + user.getPassowrd() + ":" + user.isAdult() + ":" + user.isAdmin());

		} catch (IOException e) {

			throw new DAOException(e);
		}

	}

	@Override
	public void deleteUser(User user) throws DAOException {
		// TODO Auto-generated method stub
		String readeLine;
		List<String> strings = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(RESOURCE))) {

			while ((readeLine = br.readLine()) != null) {

				strings.add(readeLine);
			}

			Iterator<String> iterator = strings.iterator();
			String iteratorString;

			int beginIndex = 0;

			while (iterator.hasNext()) {

				iteratorString = iterator.next();

				if (!iteratorString.isBlank() && !iteratorString.isEmpty()) {

					if (user.getLogin()
							.equals(iteratorString.substring(beginIndex, iteratorString.indexOf(delimeter)))) {

						beginIndex = iteratorString.indexOf(delimeter) + 1;
						iteratorString = iteratorString.replaceFirst(delimeter, " ");

						if (user.getPassowrd()
								.equals(iteratorString.substring(beginIndex, iteratorString.indexOf(delimeter)))) {

							iterator.remove();
						}
					}

				}
			}

		} catch (IOException e) {

			throw new DAOException(e);
		}

		File recourceFile = new File(RESOURCE);

		if (!recourceFile.delete()) {

			throw new DAOException("Error. File not delete.");
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(RESOURCE, true))) {

			for (String string : strings) {

				bw.write(string);
				bw.newLine();
				bw.flush();
			}

		} catch (IOException e) {

			throw new DAOException(e);
		}

	}

}
