package by.htp.la.dao.exception;

public class DAOException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DAOException(Exception e) {
		super(e);
	}
	
	public DAOException(String e) {
		super(e);
	}

}
