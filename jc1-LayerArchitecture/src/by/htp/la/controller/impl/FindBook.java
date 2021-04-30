package by.htp.la.controller.impl;

import by.htp.la.controller.LogWriter;
import by.htp.la.controller.interf.Command;
import by.htp.la.service.LibraryService;
import by.htp.la.service.exception.ServiceException;
import by.htp.la.service.impl.ServiceFactory;

public class FindBook implements Command {

	@Override
	public String execute(String request) {
		// TODO Auto-generated method stub
		String response = null;

		ServiceFactory factory = ServiceFactory.getServiceFactory();
		LibraryService bookService = factory.getLibraryService();

		try {

			response = bookService.getBook(request).inString();

		} catch (ServiceException e) {
			// write log !!!!!
			LogWriter.writeLog(e);
			response = "FindBook. Error during find the book.";
		}

		return response;
	}

}
