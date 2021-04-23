package by.htp.la.service.impl;

import by.htp.la.bean.Book;
import by.htp.la.dao.BookDAO;
import by.htp.la.dao.factory.DAOFactory;
import by.htp.la.service.LibraryService;

public class LibraryServiceImpl implements LibraryService{
	
	DAOFactory daoObjectFactory = DAOFactory.getInstance();
	BookDAO bookDAO = daoObjectFactory.getBookDAO();

	@Override
	public void addNewBook(Book book) {
		// TODO Auto-generated method stub
		
		bookDAO.addBook(book);
		
	}

	@Override
	public void addEditedBook(Book book) {
		// TODO Auto-generated method stub
		
		bookDAO.addBook(book);
	}

}
