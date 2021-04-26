package by.htp.la.dao.impl;

import by.htp.la.bean.Book;
import by.htp.la.dao.BookDAO;
import by.htp.la.dao.exception.DAOException;

public class FileBookDAO implements BookDAO {

	@Override
	public void addBook(Book book) throws DAOException{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteBook(long idBook) throws DAOException{
		// TODO Auto-generated method stub
		return false;
		
	}

	@Override
	public boolean deleteBook(Book book) throws DAOException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Book getBook(long idBook) throws DAOException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBook(String searchLine) throws DAOException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBook(boolean adult) throws DAOException{
		// TODO Auto-generated method stub
		return null;
	}

}
