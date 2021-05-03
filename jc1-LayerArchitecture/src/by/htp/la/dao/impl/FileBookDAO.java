package by.htp.la.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.htp.la.bean.Book;
import by.htp.la.helper.BookCreator;
import by.htp.la.dao.BookDAO;
import by.htp.la.dao.exception.DAOException;
import by.htp.la.helper.Path;

public class FileBookDAO implements BookDAO {

	// author:title:id:adult:bookStyle

	private final String delimeter = ":";

	@Override
	public void addBook(Book book) throws DAOException {
		// TODO Auto-generated method stub

		writeBook(book);
	}

	@Override
	public void addBooks(List<Book> books) throws DAOException {

		writeBook(books);
	}

	@Override
	public Book getBook(Book book) throws DAOException {
		// TODO Auto-generated method stub

		List<Book> books = getBooks();

		for (Book nextBook : books) {

			if (nextBook.getAuthor().equals(book.getAuthor()) && nextBook.getTitle().equals(book.getTitle())) {

				return nextBook;
			}
		}

		return null;///////// !!!!!!!!!!!

	}

	@Override
	public List<Book> getBooks() throws DAOException {
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

			throw new DAOException(e);
		}

		return books;
	}

	//////////////////////////////////////////

	private void writeBook(List<Book> books) throws DAOException {

		File recourceFile = new File(Path.BOOK_RESOURCE.getPath());

		if (!recourceFile.delete()) {

			throw new DAOException("Error. File " + Path.BOOK_RESOURCE + " do not delete.");
		}

		writeBook(books.toArray(new Book[books.size()]));
	}

	private void writeBook(Book... books) throws DAOException {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(Path.BOOK_RESOURCE.getPath(), true))) {

			for (Book book : books) {

				bw.write(book.inString());
				bw.newLine();
				bw.flush();
			}

		} catch (IOException e) {

			throw new DAOException(e);
		}

	}

}
