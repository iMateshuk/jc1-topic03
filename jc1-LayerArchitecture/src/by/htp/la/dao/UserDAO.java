package by.htp.la.dao;

import by.htp.la.bean.User;

public interface UserDAO {
	
	void signIn (String login, String password);
	void registrationUser(User user);
}
