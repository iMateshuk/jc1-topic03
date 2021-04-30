package by.htp.la.bean;

public class BookBuilder {

	// optional
	long id;
	String title;
	String author;
	String bookStyle;
	boolean adult;
	
	public BookBuilder() {
		
	}
	
	public BookBuilder setId(long id) {
		this.id = id;
		return this;
	}
	
	public BookBuilder setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public BookBuilder setAuthor(String author) {
		this.author = author;
		return this;
	}
	
	public BookBuilder setBookStyle(String bookStyle) {
		this.bookStyle = bookStyle;
		return this;
	}
	
	public BookBuilder setAdult(boolean adult) {
		this.adult = adult;
		return this;
	}
	
	
	public Book build() {
		return new Book(this);
	}

}
