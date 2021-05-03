package by.htp.la.service.impl;

import java.util.Iterator;
import java.util.List;

import by.htp.la.bean.Book;
import by.htp.la.dao.BookDAO;
import by.htp.la.dao.exception.DAOException;
import by.htp.la.factories.DAOFactory;
import by.htp.la.service.LibraryService;
import by.htp.la.service.exception.ServiceException;

public class LibraryServiceImpl implements LibraryService {

	/*
	 * final static DAOFactory daoObjectFactory = DAOFactory.getInstance(); final
	 * static BookDAO bookDAO = daoObjectFactory.getBookDAO();
	 */

	@Override
	public void addNewBook(Book book) throws ServiceException {
		// TODO Auto-generated method stub

		checkBook(book);
		
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();

		try {

			List<Book> books = bookDAO.getBooks();
			int bookSize = books.size();

			books = bookIn(books, book);

			if (bookSize - books.size() > 0) {

				throw new DAOException("Error. Book exist.");
			}

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
		
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();

		try {

			List<Book> books = bookDAO.getBooks();

			for (Book editBook : books) {

				if (editBook.getId() == book.getId()) {

					editBook.setAuthor(book.getAuthor());
					editBook.setTitle(book.getTitle());
					editBook.setBookStyle(book.getBookStyle());
					editBook.setAdult(book.isAdult());
					break;
				}
			}

			bookDAO.addBooks(books);/////////// !!!!!!!!!!!!!!!!!

		} catch (DAOException e) {
			// TODO Auto-generated catch block
			throw new ServiceException(e);
		}
	}

	@Override
	public Book getBook(Book book) throws ServiceException {
		// TODO Auto-generated method stub

		checkBook(book);
		
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();

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
		
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		BookDAO bookDAO = daoObjectFactory.getBookDAO();

		try {

			List<Book> books = bookDAO.getBooks();
			int bookSize = books.size();

			books = bookIn(books, book);

			if (!(bookSize - books.size() > 0)) {

				throw new DAOException("Error. Book not exist.");
			}

			bookDAO.addBooks(books);

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

		if (book.getId() == 0) {

			book.setId(1L + ((long) (Math.random() * 10_000L)));
		}

	}

	private List<Book> bookIn(List<Book> books, Book book) {

		Iterator<Book> bookIterator = books.iterator();

		Book checkBook;

		while (bookIterator.hasNext()) {

			checkBook = bookIterator.next();

			if (checkBook.getAuthor().equals(book.getAuthor()) && checkBook.getTitle().equals(book.getTitle())) {

				bookIterator.remove();
			}

		}

		return books;
	}

}
