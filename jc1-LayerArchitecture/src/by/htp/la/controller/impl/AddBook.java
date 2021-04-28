package by.htp.la.controller.impl;

import by.htp.la.controller.interf.Command;
import by.htp.la.service.LibraryService;
import by.htp.la.service.exception.ServiceException;
import by.htp.la.service.impl.ServiceFactory;

public class AddBook implements Command {

	@Override
	public String execute(String request) {
		// TODO Auto-generated method stub
		String response = null;

		ServiceFactory factory = ServiceFactory.getServiceFactory();
		LibraryService bookService = factory.getLibraryService();

		try {

			bookService.addNewBook(request);
			response = "New book add successfully.";

		} catch (ServiceException e) {
			// write log !!!!!

			response = "AddBook. Error during add the book.";
		}

		return response;
	}

}
