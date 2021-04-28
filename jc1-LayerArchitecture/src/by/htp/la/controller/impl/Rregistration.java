package by.htp.la.controller.impl;

import by.htp.la.bean.User;
import by.htp.la.bean.UserBuilder;
import by.htp.la.controller.interf.Command;
import by.htp.la.service.ClientService;
import by.htp.la.service.exception.ServiceException;
import by.htp.la.service.impl.ServiceFactory;

public class Rregistration implements Command {

	@Override
	public String execute(String request) {
		// TODO Auto-generated method stub
		String response = null;

		String delimeter = " ";

		String[] strings = request.split(delimeter);

		if (strings.length < 3) {

			return "Error. Rregistration. Incorrect String lenght.";
		}

		ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
		ClientService clientService = serviceFactory.getClientService();
		
		User user;
		
		if (strings.length == 3) {

			user = new UserBuilder(strings[1], strings[2]).build();

		} else if (strings.length == 4) {

			user = new UserBuilder(strings[1], strings[2]).setAdult(strings[3].equals("true")).build();

		} else {

			user = new UserBuilder(strings[1], strings[2]).setAdult(strings[3].equals("true"))
					.setAdmin(strings[4].equals("true")).build();

		}

		try {

			clientService.registrationUser(user);
			response = user.getLogin() + " add successfully.";

		} catch (ServiceException e) {
			// write log !!!!!

			response = "Rregistration. Error during add " + user.getLogin();
		}

		return response;
	}

}
