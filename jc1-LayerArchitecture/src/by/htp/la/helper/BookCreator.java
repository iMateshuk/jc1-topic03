package by.htp.la.helper;

import by.htp.la.bean.Book;

public class BookCreator {

	public static Book createBook(String[] bookData) {

		Book book;

		if (bookData.length == 2) {

			book = new Book.BookBuilder().setAuthor(bookData[0]).setTitle(bookData[1]).build();

		} else if (bookData.length == 3) {

			book = new Book.BookBuilder().setAuthor(bookData[0]).setTitle(bookData[1])
					.setId(Long.parseLong(bookData[2])).build();

		} else if (bookData.length == 4) {

			book = new Book.BookBuilder().setAuthor(bookData[0]).setTitle(bookData[1])
					.setId(Long.parseLong(bookData[2])).setAdult(bookData[3].equals("true")).build();

		} else {

			book = new Book.BookBuilder().setAuthor(bookData[0]).setTitle(bookData[1])
					.setId(Long.parseLong(bookData[2])).setAdult(bookData[3].equals("true")).setBookStyle(bookData[4])
					.build();
		}

		return book;
	}

}
