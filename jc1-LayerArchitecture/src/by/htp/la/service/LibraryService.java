package by.htp.la.service;

import by.htp.la.bean.Book;
import by.htp.la.service.exception.ServiceException;

public interface LibraryService {

	void addNewBook(String string) throws ServiceException;
	void addEditedBook(String string) throws ServiceException;
	void deleteBook (String string) throws ServiceException;
	Book getBook (String string) throws ServiceException;
}
