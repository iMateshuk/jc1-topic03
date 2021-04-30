package by.htp.la.controller.impl;

import by.htp.la.bean.User;
import by.htp.la.bean.UserBuilder;
import by.htp.la.controller.LogWriter;
import by.htp.la.controller.interf.Command;
import by.htp.la.service.ClientService;
import by.htp.la.service.exception.ServiceException;
import by.htp.la.service.impl.ServiceFactory;

public class DeleteUser implements Command {

	@Override
	public String execute(String request) {
		// TODO Auto-generated method stub
		String response = null;

		String delimeter = " ";

		String[] strings = request.split(delimeter);

		if (strings.length < 2) {

			return "Error. Rregistration. Incorrect String lenght.";
		}

		ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
		ClientService clientService = serviceFactory.getClientService();

		User user = new UserBuilder(strings[0], strings[1]).build();

		try {

			clientService.deleteUser(user);
			response = user.getLogin() + " delete successfull.";

		} catch (ServiceException e) {
			// write log !!!!!
			LogWriter.writeLog(e);
			response = "DeleteUser. Error during delete " + user.getLogin();
		}

		return response;
	}

}
