package by.htp.la.dao;

import by.htp.la.bean.User;
import by.htp.la.dao.exception.DAOException;

public interface UserDAO {
	
	void signIn (String login, String password) throws DAOException;
	void registrationUser(User user) throws DAOException;
	boolean deleteUser(User user) throws DAOException;
}
