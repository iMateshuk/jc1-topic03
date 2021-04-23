package by.htp.la.service.impl;

import by.htp.la.bean.User;
import by.htp.la.dao.UserDAO;
import by.htp.la.dao.factory.DAOFactory;
import by.htp.la.service.ClientService;

public class ClientServiceImpl implements ClientService {

	DAOFactory daoObjectFactory = DAOFactory.getInstance();
	UserDAO userDAO = daoObjectFactory.getUserDAO();
	
	@Override
	public void singIn(String login, String password) {
		// TODO Auto-generated method stub

		userDAO.signIn(login, password);
		
	}

	@Override
	public void singOut(String login) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registration(User user) {
		// TODO Auto-generated method stub
		
		userDAO.registrationUser(user);
	}

}
