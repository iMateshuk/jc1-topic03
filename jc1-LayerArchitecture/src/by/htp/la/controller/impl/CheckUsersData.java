package by.htp.la.controller.impl;

import by.htp.la.service.exception.ServiceException;

public class CheckUsersData {
	
	public static String[] checkData(String request) throws ServiceException {
		
		String delimeter = " ";

		String[] userData = request.split(delimeter);

		if (userData.length < 2) {

			throw new  ServiceException("Error. Incorrect String lenght.");
		}
		
		return userData;
	}

}
