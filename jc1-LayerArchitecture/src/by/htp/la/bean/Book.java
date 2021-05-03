package by.htp.la.bean;

import java.io.Serializable;

public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id = 0;
	private String title = "unknown";
	private String author = "unknown";
	private String bookStyle = "unknown";
	private boolean adult = false;

	public Book() {

	}

	Book(BookBuilder builder) {
		this.id = builder.id;
		this.title = builder.title;
		this.author = builder.author;
		this.bookStyle = builder.bookStyle;
		this.adult = builder.adult;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookStyle() {
		return bookStyle;
	}

	public void setBookStyle(String bookStyle) {
		this.bookStyle = bookStyle;
	}

	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (adult ? 1231 : 1237);
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookStyle == null) ? 0 : bookStyle.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Book other = (Book) obj;
		if (adult != other.adult)
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookStyle == null) {
			if (other.bookStyle != null)
				return false;
		} else if (!bookStyle.equals(other.bookStyle))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [id=" + id + ", title=" + title + ", author=" + author + ", bookStyle="
				+ bookStyle + "]";
	}

	public String inString() {
		// author:title:id:adult:bookStyle
		return author + ":" + title + ":" + id + ":" + Boolean.toString(adult) + ":" + bookStyle;
	}

	//Builder

	public static class BookBuilder {

		// optional
		private long id;
		private String title;
		private String author;
		private String bookStyle;
		private boolean adult;

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

}
