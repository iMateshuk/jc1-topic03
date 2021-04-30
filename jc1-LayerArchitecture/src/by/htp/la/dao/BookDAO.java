package by.htp.la.dao;

import by.htp.la.bean.Book;
import by.htp.la.dao.exception.DAOException;

public interface BookDAO {
	
	void addBook(String string) throws DAOException;
	void addEditedBook(String string) throws DAOException;
	void deleteBook (String string) throws DAOException;
	Book getBook(String string) throws DAOException;
	

}
