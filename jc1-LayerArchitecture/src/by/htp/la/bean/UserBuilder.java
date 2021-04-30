package by.htp.la.bean;

public class UserBuilder {

	//required
	String login;
	String password;
	
	
	//optional
	boolean adult;
	boolean admin;

	public UserBuilder (String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public UserBuilder setAdult(boolean adult) {
		this.adult = adult;
		return this;
	}
	
	public UserBuilder setAdmin(boolean admin) {
		this.admin = admin;
		return this;
	}
	
	public User build() {
		return new User(this);
	}
}
