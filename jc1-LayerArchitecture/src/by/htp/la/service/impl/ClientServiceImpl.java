package by.htp.la.service.impl;

import by.htp.la.bean.User;
import by.htp.la.dao.UserDAO;
import by.htp.la.dao.exception.DAOException;
import by.htp.la.factories.DAOFactory;
import by.htp.la.service.ClientService;
import by.htp.la.service.exception.ServiceException;

public class ClientServiceImpl implements ClientService {

	private final DAOFactory daoObjectFactory = DAOFactory.getInstance();
	private final UserDAO userDAO = daoObjectFactory.getUserDAO();

	@Override
	public String singIn(String login, String password) throws ServiceException {
		// TODO Auto-generated method stub

		if (login.matches(".*:.*") || password.matches(".*:.*")) {

			throw new ServiceException("Error. SignIn. Name or password contains illegal parameter - :");
		}

		if (login.matches(".*\\W.*")) {

			throw new ServiceException("Error. SignIn. Name contains invalid parameters.");
		}

		if (password.length() < 3) {

			throw new ServiceException("Error. SignIn. Password length is invalid.");
		}

		try {

			return userDAO.signIn(login, password);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}

	}

	@Override
	public void registrationUser(User user) throws ServiceException {
		// TODO Auto-generated method stub

		checkUser(user);

		try {

			userDAO.registrationUser(user);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteUser(User user) throws ServiceException {
		// TODO Auto-generated method stub
		checkUser(user);

		try {

			userDAO.deleteUser(user);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
	}

	/////////////////////////////////

	private void checkUser(User user) throws ServiceException {

		if (user == null) {

			throw new ServiceException("Error. User is null");
		}

		if (user.getLogin().matches(".*\\W.*")) {

			throw new ServiceException("Error. Name contains invalid parameters .");
		}

		if (user.getPassowrd().length() < 3) {

			throw new ServiceException("Error. Password length is invalid.");
		}

	}

}
