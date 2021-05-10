package by.htp.la.dao;

import by.htp.la.bean.User;
import by.htp.la.dao.exception.DAOException;

public interface UserDAO {
	
	String signIn (String login, String password) throws DAOException;
	void registrationUser(User user) throws DAOException;
	void deleteUser(User user) throws DAOException;
}
