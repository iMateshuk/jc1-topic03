package by.htp.la.dao;

import by.htp.la.bean.Book;
import by.htp.la.dao.exception.DAOException;

public interface BookDAO {
	
	void addBook(Book book) throws DAOException;
	void addEditedBook(Book book) throws DAOException;
	void deleteBook (Book book) throws DAOException;
	Book getBook (Book book) throws DAOException;
}
