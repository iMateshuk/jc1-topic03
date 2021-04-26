package by.htp.la.service.impl;

import by.htp.la.bean.User;
import by.htp.la.dao.UserDAO;
import by.htp.la.dao.exception.DAOException;
import by.htp.la.dao.impl.DAOFactory;
import by.htp.la.service.ClientService;
import by.htp.la.service.exception.ServiceException;

public class ClientServiceImpl implements ClientService {

	DAOFactory daoObjectFactory = DAOFactory.getInstance();
	UserDAO userDAO = daoObjectFactory.getUserDAO();
	
	@Override
	public void singIn(String login, String password) throws ServiceException{
		// TODO Auto-generated method stub
		if (login == null || password == null) {
			throw new ServiceException("Can't singIn. login or password is null");
		}

		try {
			userDAO.signIn(login, password);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
		
	}

	@Override
	public void registrationUser(User user) throws ServiceException{
		// TODO Auto-generated method stub
		if (user == null) {
			throw new ServiceException("Can't regist User. User is null");
		}
		
		try {
			userDAO.registrationUser(user);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean deleteUser(User user) throws ServiceException{
		// TODO Auto-generated method stub
		if (user == null) {
			throw new ServiceException("Can't delete User. User is null");
		}
		
		try {
			return userDAO.deleteUser(user);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
	}

}
