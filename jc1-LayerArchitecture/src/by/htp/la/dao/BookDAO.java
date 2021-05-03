package by.htp.la.dao;

import java.util.List;

import by.htp.la.bean.Book;
import by.htp.la.dao.exception.DAOException;

public interface BookDAO {
	
	void addBook(Book book) throws DAOException;
	void addBooks(List<Book> books) throws DAOException;
	Book getBook(Book book) throws DAOException;
	List<Book> getBooks() throws DAOException;
	

}
