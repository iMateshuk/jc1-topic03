package by.htp.la.factories;

import by.htp.la.dao.BookDAO;
import by.htp.la.dao.UserDAO;
import by.htp.la.dao.impl.FileBookDAO;
import by.htp.la.dao.impl.FileUserDAO;

public class DAOFactory {

	private static final DAOFactory instance = new DAOFactory();

	private final BookDAO fileBookImpl = new FileBookDAO();
	private final UserDAO fileUserImpl = new FileUserDAO();

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return instance;
	}

	public BookDAO getBookDAO() {
		return fileBookImpl;
	}

	public UserDAO getUserDAO() {
		return fileUserImpl;
	}

}
