package by.htp.la.util;

import by.htp.la.service.exception.ServiceException;

public class CheckBooksData {

	public static String[] checkData(String request) throws ServiceException {

		String delimeter = " ";

		String[] bookData = request.split(delimeter);

		if (bookData.length < 2) {

			throw new ServiceException("Error. Book. Incorrect String lenght in request.");
		}

		for (String string : bookData) {

			if (string.matches(".*:.*")) {

				throw new ServiceException("Error. Book. Request contains illegal parameter - :");

			}

		}

		return bookData;
	}

}
