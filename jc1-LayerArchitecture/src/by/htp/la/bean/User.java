package by.htp.la.bean;

public class User {
	
	String login;
	String passowrd;
	
	public User(String login, String passowrd) {
		this.login = login;
		this.passowrd = passowrd;
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassowrd() {
		return passowrd;
	}
	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((passowrd == null) ? 0 : passowrd.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (passowrd == null) {
			if (other.passowrd != null)
				return false;
		} else if (!passowrd.equals(other.passowrd))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "User [login=" + login + ", passowrd=" + passowrd + "]";
	}
	
}
