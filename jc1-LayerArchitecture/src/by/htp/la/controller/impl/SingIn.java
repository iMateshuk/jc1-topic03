package by.htp.la.controller.impl;

import by.htp.la.controller.interf.Command;
import by.htp.la.factories.ServiceFactory;
import by.htp.la.service.ClientService;
import by.htp.la.service.exception.ServiceException;
import by.htp.la.util.LogWriter;

public class SingIn implements Command {

	@Override
	public String execute(String request) {
		// TODO Auto-generated method stub
		String response = null;

		ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
		ClientService clientService = serviceFactory.getClientService();

		try {
			
			String[] userData = CheckUsersData.checkData(request);
			
			if (userData[0].isEmpty() || userData[0].isBlank() || userData[1].isEmpty() || userData[1].isBlank()) {

				throw new  ServiceException("Error. SignIn. Name or passowrd contains invalid parameters .");
			}

			response = clientService.singIn(userData[0], userData[1]);

		} catch (ServiceException e) {
			// write log !!!!!
			LogWriter.writeLog(e);
			response = "SignIn. Error during login procedure.";
		}

		return response;
	}

}
