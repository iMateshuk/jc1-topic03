package by.htp.la.controller.impl;

import by.htp.la.bean.User;
import by.htp.la.helper.UserCreator;
import by.htp.la.controller.interf.Command;
import by.htp.la.factories.ServiceFactory;
import by.htp.la.helper.LogWriter;
import by.htp.la.service.ClientService;
import by.htp.la.service.exception.ServiceException;

public class Rregistration implements Command {

	@Override
	public String execute(String request) {
		// TODO Auto-generated method stub
		String response = null;

		ServiceFactory serviceFactory = ServiceFactory.getServiceFactory();
		ClientService clientService = serviceFactory.getClientService();

		try {

			String[] userData = CheckUsersData.checkData(request);

			User user = UserCreator.createUser(userData);

			clientService.registrationUser(user);
			response = user.getLogin() + " add successfully.";

		} catch (ServiceException e) {
			// write log !!!!!
			LogWriter.writeLog(e);
			response = "Error. Controller Rregistration.";
		}

		return response;
	}

}
