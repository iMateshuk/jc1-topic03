package by.htp.la.service.impl;

import java.util.Iterator;
import java.util.List;

import by.htp.la.bean.User;
import by.htp.la.dao.UserDAO;
import by.htp.la.dao.exception.DAOException;
import by.htp.la.factories.DAOFactory;
import by.htp.la.service.ClientService;
import by.htp.la.service.exception.ServiceException;

public class ClientServiceImpl implements ClientService {
	
	/*
	 * private final DAOFactory daoObjectFactory = DAOFactory.getInstance(); private
	 * final UserDAO userDAO = daoObjectFactory.getUserDAO();
	 */

	@Override
	public String singIn(String login, String password) throws ServiceException {
		// TODO Auto-generated method stub

		if (login.matches(".*\\W.*")) {

			throw new ServiceException("Error. SignIn. Name contains invalid parameters .");
		}

		if (password.length() < 3) {

			throw new ServiceException("Error. SignIn. Password length is invalid.");
		}

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoObjectFactory.getUserDAO();

		try {

			String response = null;
			List<User> users = userDAO.getUsers();

			for (User user : users) {

				if (user.getLogin().equals(login) && user.getPassowrd().equals(password)) {

					response = user.inString();
					break;
				}

			}

			if (response == null) {

				throw new ServiceException("Error. SignIn. User not found.");

			}

			return response;

			// return userDAO.signIn(login, password);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}

	}

	@Override
	public void registrationUser(User user) throws ServiceException {
		// TODO Auto-generated method stub

		checkUser(user);
		
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoObjectFactory.getUserDAO();

		try {

			List<User> users = userDAO.getUsers();

			int usersSize = users.size();

			users = userIn(users, user);

			if (usersSize - users.size() > 0) {

				throw new ServiceException("Error. User in file.");
			}

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

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoObjectFactory.getUserDAO();
		
		try {

			List<User> users = userDAO.getUsers();

			int usersSize = users.size();

			users = userIn(users, user);

			if (!(usersSize - users.size() > 0)) {

				throw new ServiceException("Error. User not in file.");
			}

			userDAO.deleteUser(users);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
	}

	/////////////////////////////////

	private void checkUser(User user) throws ServiceException {

		if (user == null) {

			throw new ServiceException("Error. Can't regist User. User is null");
		}

		if (user.getLogin().matches(".*\\W.*")) {

			throw new ServiceException("Error. SignIn. Name contains invalid parameters .");
		}

		if (user.getPassowrd().length() < 3) {

			throw new ServiceException("Error. SignIn. Password length is invalid.");
		}

	}

	private List<User> userIn(List<User> users, User user) {

		Iterator<User> userIterator = users.iterator();

		// Comparator<User> userComparator = new UserComparator();

		User checkUser;

		while (userIterator.hasNext()) {

			checkUser = userIterator.next();

			// if (userComparator.compare(checkUser, user) == 0) {
			if (checkUser.getLogin().compareTo(user.getLogin()) == 0) {

				userIterator.remove();
			}

		}

		return users;
	}

}
