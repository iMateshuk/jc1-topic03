package by.htp.la.controller.impl;

import by.htp.la.bean.Book;
import by.htp.la.helper.BookCreator;
import by.htp.la.controller.interf.Command;
import by.htp.la.factorys.ServiceFactory;
import by.htp.la.helper.LogWriter;
import by.htp.la.service.LibraryService;
import by.htp.la.service.exception.ServiceException;

public class DeleteBook implements Command {

	@Override
	public String execute(String request) {
		// TODO Auto-generated method stub
		String response = null;

		ServiceFactory factory = ServiceFactory.getServiceFactory();
		LibraryService bookService = factory.getLibraryService();

		try {
			
			String[] bookData = CheckBooksData.checkData(request);

			Book book = BookCreator.createBook(bookData);

			bookService.deleteBook(book);
			response = "Book delete successfully.";

		} catch (ServiceException e) {
			// write log !!!!!
			LogWriter.writeLog(e);
			response = "DelBook. Error during delete the book.";
		}

		return response;
	}

}
