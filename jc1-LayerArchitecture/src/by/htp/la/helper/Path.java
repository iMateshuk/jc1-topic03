package by.htp.la.helper;

public enum Path {
	
	TEMP_DIR(System.getProperty("java.io.tmpdir")),
	LOG_FILE("resource\\Library.log"),
	BOOK_RESOURCE("resource\\bookData.txt"),
	USER_RESOURCE("resource\\userData.txt");

	private String string;

	Path(String string) {
		this.string = string;

	}

	public String getPath() {
		return string;
	}

}
