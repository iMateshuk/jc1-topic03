package by.htp.la.dao;

import by.htp.la.bean.Book;
import by.htp.la.dao.exception.DAOException;

public interface BookDAO {
	
	void addBook(Book book) throws DAOException;
	
	boolean deleteBook (long idBook) throws DAOException;
	boolean deleteBook (Book book) throws DAOException;
	
	Book getBook(long idBook) throws DAOException;
	Book getBook(String searchString) throws DAOException;
	Book getBook(boolean adult) throws DAOException;

}
