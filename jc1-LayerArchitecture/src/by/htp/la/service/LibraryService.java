package by.htp.la.service;

import by.htp.la.bean.Book;
import by.htp.la.service.exception.ServiceException;

public interface LibraryService {

	void addNewBook(Book book) throws ServiceException;
	void addEditedBook(Book book) throws ServiceException;
	void deleteBook (Book book) throws ServiceException;
	Book getBook (Book book) throws ServiceException;
}
