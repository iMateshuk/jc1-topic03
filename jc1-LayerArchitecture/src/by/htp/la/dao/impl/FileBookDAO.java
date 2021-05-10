package by.htp.la.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import by.htp.la.bean.Book;
import by.htp.la.dao.BookDAO;
import by.htp.la.dao.exception.DAOException;
import by.htp.la.util.BookCreator;
import by.htp.la.util.Path;

public class FileBookDAO implements BookDAO {

	// author:title:id:adult:bookStyle

	private final String delimeter = ":";

	@Override
	public void addBook(Book book) throws DAOException {
		// TODO Auto-generated method stub

		try {

			List<Book> books = getBooks();

			int bookSize = books.size();

			books = bookIn(books, book);

			if (bookSize - books.size() > 0) {

				throw new DAOException("Error. Book exist.");
			}
			
			if (book.getId() == 0) {

				book.setId(1L + ((long) (Math.random() * 10_000L)));
			}

			writeBook(book);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}
	}

	@Override
	public void addEditedBook(Book book) throws DAOException {

		try {
			
			List<Book> books = getBooks();
			
			if (!editBook(books, book)) {
				
				throw new DAOException("Error. Book exist in file.");
			}
			
			writeBook(book);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}
	}

	@Override
	public Book getBook(Book book) throws DAOException {
		// TODO Auto-generated method stub

		Book findBook = null;

		try {

			List<Book> books = getBooks();

			for (Book nextBook : books) {

				if (nextBook.getAuthor().equals(book.getAuthor()) && nextBook.getTitle().equals(book.getTitle())) {

					findBook = nextBook;
				}
			}

			if (findBook == null) {
				throw new DAOException("Error. Book not in file.");
			}

			return findBook;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}

	}

	@Override
	public void deleteBook(Book book) throws DAOException {
		// TODO Auto-generated method stub

		try {

			List<Book> books = getBooks();

			int bookSize = books.size();

			books = bookIn(books, book);

			if (!(bookSize - books.size() > 0)) {

				throw new DAOException("Error. Book not exist.");
			}

			writeBook(books);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new DAOException(e);
		}

	}

	//////////////////////////////////////////

	private void writeBook(List<Book> books) throws IOException {

		File recourceFile = new File(Path.BOOK_RESOURCE.getPath());

		if (!recourceFile.delete()) {

			throw new IOException("Error. File " + Path.BOOK_RESOURCE + " do not delete.");
		}

		try {

			writeBook(books.toArray(new Book[books.size()]));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IOException(e);
		}
	}

	private void writeBook(Book... books) throws IOException {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(Path.BOOK_RESOURCE.getPath(), true))) {

			for (Book book : books) {

				bw.write(book.inString());
				bw.newLine();
				bw.flush();
			}

		} catch (IOException e) {

			throw new IOException(e);
		}

	}

	private List<Book> getBooks() throws IOException {
		// TODO Auto-generated method stub
		String readeLine;
		ArrayList<Book> books = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(Path.BOOK_RESOURCE.getPath()))) {

			while ((readeLine = br.readLine()) != null) {

				if (!readeLine.isBlank() && !readeLine.isEmpty()) {

					books.add(BookCreator.createBook(readeLine.split(delimeter)));
				}
			}

		} catch (IOException e) {

			throw new IOException(e);
		}

		return books;
	}

	private List<Book> bookIn(List<Book> books, Book book) {

		Iterator<Book> bookIterator = books.iterator();

		Book checkBook;

		while (bookIterator.hasNext()) {

			checkBook = bookIterator.next();

			if (checkBook.getAuthor().equals(book.getAuthor()) && checkBook.getTitle().equals(book.getTitle())) {

				bookIterator.remove();
			}

		}

		return books;
	}
	
	private Boolean editBook(List<Book> books, Book book) {
		
		for (Book editBook : books) {

			if (editBook.getId() == book.getId()) {

				editBook.setAuthor(book.getAuthor());
				editBook.setTitle(book.getTitle());
				editBook.setBookStyle(book.getBookStyle());
				editBook.setAdult(book.isAdult());
				return true;
			}
		}
		
		return false;
	}

}
