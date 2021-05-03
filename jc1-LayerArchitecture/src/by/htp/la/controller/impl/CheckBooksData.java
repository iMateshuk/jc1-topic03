package by.htp.la.controller.impl;

import by.htp.la.service.exception.ServiceException;

public class CheckBooksData {
	
public static String[] checkData(String request) throws ServiceException {
		
		String delimeter = " ";

		String[] bookData = request.split(delimeter);

		if (bookData.length < 2) {

			throw new  ServiceException("Error. Incorrect String lenght.");
		}
		
		return bookData;
	}

}
