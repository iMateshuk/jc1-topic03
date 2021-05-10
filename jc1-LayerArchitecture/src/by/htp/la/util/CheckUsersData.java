package by.htp.la.util;

import by.htp.la.service.exception.ServiceException;

public class CheckUsersData {

	public static String[] checkData(String request) throws ServiceException {

		String delimeter = " ";

		String[] userData = request.split(delimeter);

		if (userData.length < 2) {

			throw new ServiceException("Error. User. Incorrect String lenght in request.");
		}

		for (String string : userData) {

			if (string.matches(".*:.*")) {

				throw new ServiceException("Error. User. Request contains illegal parameter - :");

			}

		}

		return userData;
	}

}
