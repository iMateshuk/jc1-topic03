package by.htp.la.service;

import by.htp.la.bean.User;

public interface ClientService {

	void singIn(String login, String password);
	void singOut(String login);
	void registration(User user);
}
