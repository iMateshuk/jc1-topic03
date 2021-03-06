package by.htp.la.service;

import by.htp.la.bean.User;
import by.htp.la.service.exception.ServiceException;

public interface ClientService {

	String singIn(String login, String password) throws ServiceException;
	void registrationUser(User user) throws ServiceException;
	void deleteUser(User user) throws ServiceException;
}
