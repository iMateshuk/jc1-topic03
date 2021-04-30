package by.htp.la.controller.impl;

import by.htp.la.controller.LogWriter;
import by.htp.la.controller.interf.Command;
import by.htp.la.service.ClientService;
import by.htp.la.service.exception.ServiceException;
import by.htp.la.service.impl.ServiceFactory;

public class SingIn implements Command {

	@Override
	public String execute(String request) {
		// TODO Auto-generated method stub
		String response = null;

		String delimeter = " ";

		String[] strings = request.split(delimeter);

		if (strings.length < 2) {

			return "Error. SignIn. Incorrect String lenght.";
		}

		ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
		ClientService clientService = serviceFactory.getClientService();

		try {

			response = clientService.singIn(strings[0], strings[1]);

		} catch (ServiceException e) {
			// write log !!!!!
			LogWriter.writeLog(e);
			response = "SignIn. Error during login procedure.";
		}

		return response;
	}

}
