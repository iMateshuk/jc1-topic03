package by.htp.la.controller.impl;

import by.htp.la.controller.interf.Command;
import by.htp.la.service.ClientService;
import by.htp.la.service.exception.ServiceException;
import by.htp.la.service.impl.ServiceFactory;

public class SingIn implements Command {

	@Override
	public String execute(String request) {
		// TODO Auto-generated method stub
		String login = null;
		String password = null;
		String response = null;

		ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
		ClientService clientService = serviceFactory.getClientService();

		try {
			clientService.singIn(login, password);
			response = "Welcome";
		} catch (ServiceException e) {
			// write log !!!!!
			response = "Error duiring login procedure";
		}
		
		return response;
	}

}
