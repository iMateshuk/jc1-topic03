package by.htp.la.service;

import by.htp.la.bean.Book;
import by.htp.la.service.exception.ServiceException;

public interface LibraryService {

	void addNewBook(Book book) throws ServiceException;
	void addEditedBook(Book book) throws ServiceException;
	boolean deleteBook (Book book) throws ServiceException;
	boolean deleteBook (long id) throws ServiceException;
}
