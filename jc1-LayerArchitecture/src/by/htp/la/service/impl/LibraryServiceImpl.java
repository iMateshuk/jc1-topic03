package by.htp.la.service.impl;

import by.htp.la.bean.Book;
import by.htp.la.dao.BookDAO;
import by.htp.la.dao.exception.DAOException;
import by.htp.la.dao.impl.DAOFactory;
import by.htp.la.service.LibraryService;
import by.htp.la.service.exception.ServiceException;

public class LibraryServiceImpl implements LibraryService{
	
	DAOFactory daoObjectFactory = DAOFactory.getInstance();
	BookDAO bookDAO = daoObjectFactory.getBookDAO();

	@Override
	public void addNewBook(Book book) throws ServiceException {
		// TODO Auto-generated method stub
		if (book == null) {
			throw new ServiceException("Can't add Book. Book must not be null");
		}
		
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
		if (book == null) {
			throw new ServiceException("Can't edit Book. Book must not be null");
		}
		
		try {
			bookDAO.addBook(book);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean deleteBook(Book book) throws ServiceException {
		// TODO Auto-generated method stub
		if (book == null) {
			throw new ServiceException("Can't delete Book. Book must not be null");
		}
		
		try {
			return bookDAO.deleteBook(book);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean deleteBook(long id) throws ServiceException {
		// TODO Auto-generated method stub
		if (id == 0) {
			throw new ServiceException("Can't delete Book. ID Book must not be 0");
		}
		
		try {
			return bookDAO.deleteBook(id);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
	}

}
