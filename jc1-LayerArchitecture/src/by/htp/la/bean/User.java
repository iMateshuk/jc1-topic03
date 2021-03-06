package by.htp.la.bean;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String login;
	private String password;
	private boolean admin;
	private boolean adult;

	public User() {

	}

	User(UserBuilder builder) {
		this.login = builder.login;
		this.password = builder.password;
		this.adult = builder.adult;
		this.admin = builder.admin;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassowrd() {
		return password;
	}

	public void setPassowrd(String passowrd) {
		this.password = passowrd;
	}

	public boolean isAdmin() {
		return admin;
	}

	public boolean isAdult() {
		return adult;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [login=" + login + ", passowrd=" + password + "]";
	}

	public String inString() {
		return login + ":" + password + ":" + Boolean.toString(adult) + ":" + Boolean.toString(admin);
	}
	
	//Builder
	
	public static class UserBuilder {

		//required
		private String login;
		private String password;
		
		
		//optional
		private boolean adult;
		private boolean admin;
		
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

}
