package by.htp.la.service.factory;

import by.htp.la.service.ClientService;
import by.htp.la.service.LibraryService;
import by.htp.la.service.impl.ClientServiceImpl;
import by.htp.la.service.impl.LibraryServiceImpl;

public class ServiceFactory {
	
	private static final ServiceFactory instance = new ServiceFactory();
	
	private final ClientService clientServiceImpl = new ClientServiceImpl();
	private final LibraryService libraryServiceImpl = new LibraryServiceImpl();
	
	private ServiceFactory(){}
	
	public static ServiceFactory getServiceFactory() {
		return instance;
	}
	
	public ClientService getClientService() {
		return clientServiceImpl;
	}
	
	public LibraryService getLibraryService() {
		return libraryServiceImpl;
	}

}
