package by.htp.la.service.impl;

import by.htp.la.bean.Book;
import by.htp.la.dao.BookDAO;
import by.htp.la.dao.exception.DAOException;
import by.htp.la.dao.impl.DAOFactory;
import by.htp.la.service.LibraryService;
import by.htp.la.service.exception.ServiceException;

public class LibraryServiceImpl implements LibraryService {

	@Override
	public void addNewBook(String string) throws ServiceException {
		// TODO Auto-generated method stub

		if (string == null) {

			throw new ServiceException("Can't add Book. String must not be null");
		}

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();

		try {

			bookDAO.addBook(string);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}

	}

	@Override
	public void addEditedBook(String string) throws ServiceException {
		// TODO Auto-generated method stub

		if (string == null) {

			throw new ServiceException("Can't edit Book. String must not be null");
		}

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();

		try {

			bookDAO.addBook(string);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteBook(String string) throws ServiceException {
		// TODO Auto-generated method stub
		if (string == null) { // контролирует controller

			throw new ServiceException("Can't delete Book. String must not be null");
		}

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();

		try {

			bookDAO.deleteBook(string);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
	}

	@Override
	public Book getBook(String string) throws ServiceException {
		// TODO Auto-generated method stub
		if (string == null) { // контролирует controller

			throw new ServiceException("Can't find Book. String must not be null");
		}

		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();

		try {

			return bookDAO.getBook(string);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
	}

}
