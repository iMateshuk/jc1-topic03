package by.htp.la.controller.impl;

import by.htp.la.bean.Book;
import by.htp.la.controller.interf.Command;
import by.htp.la.factories.ServiceFactory;
import by.htp.la.service.LibraryService;
import by.htp.la.service.exception.ServiceException;
import by.htp.la.util.BookCreator;
import by.htp.la.util.LogWriter;

public class AddBook implements Command {

	@Override
	public String execute(String request) {
		// TODO Auto-generated method stub
		
		String response = null;
		
		ServiceFactory factory = ServiceFactory.getServiceFactory();
		LibraryService bookService = factory.getLibraryService();
		
		try {
			
			String[] bookData = CheckBooksData.checkData(request);

			Book book = BookCreator.createBook(bookData);

			bookService.addNewBook(book);
			response = "New book add successfully.";

		} catch (ServiceException e) {
			// write log !!!!!
			LogWriter.writeLog(e);
			response = "AddBook. Error during add the book.";
		}

		return response;
	}

}
