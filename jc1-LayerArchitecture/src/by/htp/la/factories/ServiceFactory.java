package by.htp.la.factories;

import by.htp.la.service.ClientService;
import by.htp.la.service.LibraryService;
import by.htp.la.service.impl.ClientServiceImpl;
import by.htp.la.service.impl.LibraryServiceImpl;

public class ServiceFactory {

	private static final ServiceFactory instance = new ServiceFactory();

	private final ClientService clientService = new ClientServiceImpl();
	private final LibraryService libraryService = new LibraryServiceImpl();

	private ServiceFactory() {
	}

	public static ServiceFactory getServiceFactory() {
		return instance;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public LibraryService getLibraryService() {
		return libraryService;
	}

}
