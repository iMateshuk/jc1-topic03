package by.htp.la.dao;

import by.htp.la.bean.Book;

public interface BookDAO {
	
	void addBook(Book book);
	
	void deleteBook (long idBook);
	void deleteBook (Book book);
	
	Book getBook(long idBook);
	Book getBook(String searchLine);
	Book getBook(boolean adult);

}
