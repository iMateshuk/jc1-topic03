package by.htp.la.service.impl;

import by.htp.la.bean.Book;
import by.htp.la.dao.BookDAO;
import by.htp.la.dao.exception.DAOException;
import by.htp.la.factories.DAOFactory;
import by.htp.la.service.LibraryService;
import by.htp.la.service.exception.ServiceException;

public class LibraryServiceImpl implements LibraryService {

	 final static DAOFactory daoObjectFactory = DAOFactory.getInstance();
	 final static BookDAO bookDAO = daoObjectFactory.getBookDAO();
	 

	@Override
	public void addNewBook(Book book) throws ServiceException {
		// TODO Auto-generated method stub

		checkBook(book);

		try {

			bookDAO.addBook(book);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}

	}

	@Override
	public void addEditedBook(Book book) throws ServiceException {
		// TODO Auto-generated method stub

		checkBook(book);

		try {

			bookDAO.addEditedBook(book);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
	}

	@Override
	public Book getBook(Book book) throws ServiceException {
		// TODO Auto-generated method stub

		checkBook(book);

		try {

			return bookDAO.getBook(book);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
	}

	@Override
	public void deleteBook(Book book) throws ServiceException {
		// TODO Auto-generated method stub
		checkBook(book);

		try {

			bookDAO.deleteBook(book);

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}

	}

	////////////////////////

	private void checkBook(Book book) throws ServiceException {

		if (book == null) {

			throw new ServiceException("Error. Can't add Book. Book is null");
		}

		if (book.getAuthor() == null || book.getTitle() == null) {

			throw new ServiceException("Error. Can't add Book. Author or Title is null");
		}

	}

}
