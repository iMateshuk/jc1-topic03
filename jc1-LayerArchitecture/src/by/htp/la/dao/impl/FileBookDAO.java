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
import by.htp.la.bean.BookBuilder;
import by.htp.la.dao.BookDAO;
import by.htp.la.dao.exception.DAOException;

public class FileBookDAO implements BookDAO {

	// author:title:id:adult:bookStyle

	private final String RESOURCE = "resource\\bookData.txt";
	private final String delimeter = ":";

	@Override
	public void addBook(String request) throws DAOException {
		// TODO Auto-generated method stub

		Book book = createBook(request);

		List<String> books = readBooksFile();
		int beginIndex;

		for (String string : books) {

			beginIndex = 0;

			if (!string.isBlank() && !string.isEmpty()) {

				if (book.getAuthor().equals(string.substring(beginIndex, string.indexOf(delimeter)))) {

					beginIndex = string.indexOf(delimeter) + 1;
					string = string.replaceFirst(delimeter, " ");

					if (book.getTitle().equals(string.substring(beginIndex, string.indexOf(delimeter)))) {

						throw new DAOException("Error. AddBook. Book exist.");
					}
				}
			}
		}

		writeBook(book.inString());

	}

	@Override
	public void deleteBook(String request) throws DAOException {
		// TODO Auto-generated method stub

		Book book = createBook(request);

		List<String> books = readBooksFile();
		int size = books.size();

		books = delBook(books, book);

		if (size - books.size() > 0) {

			writeBook(books);
		} else {

			throw new DAOException("Error. DeleteBook. Book not found.");
		}

	}

	@Override
	public Book getBook(String request) throws DAOException {
		// TODO Auto-generated method stub

		Book book = createBook(request);

		List<String> books = readBooksFile();

		for (String string : books) {

			if (string.matches(".*" + book.getAuthor() + ".*") && string.matches(".*" + book.getTitle() + ".*")) {

				return createBook("getBook " + string.replaceAll(":", " "));
			}
		}

		throw new DAOException("Error. Dont find the book: " + book.getAuthor() + " " + book.getTitle());

	}

	//////////////////////////////////////////

	private Book createBook(String string) {

		String delimetr = " ";
		String[] strings = string.split(delimetr);
		Book book;

		if (strings.length == 3) {

			book = new BookBuilder().setAuthor(strings[1]).setTitle(strings[2]).build();

		} else if (strings.length == 4) {

			book = new BookBuilder().setAuthor(strings[1]).setTitle(strings[2]).setId(Long.parseLong(strings[3]))
					.build();

		} else if (strings.length == 5) {

			book = new BookBuilder().setAuthor(strings[1]).setTitle(strings[2]).setId(Long.parseLong(strings[3]))
					.setAdult(strings[4].equals("true")).build();

		} else {

			book = new BookBuilder().setAuthor(strings[1]).setTitle(strings[2]).setId(Long.parseLong(strings[3]))
					.setAdult(strings[4].equals("true")).setBookStyle(strings[5]).build();
		}

		return book;
	}

	private ArrayList<String> readBooksFile() throws DAOException {

		String readeLine;
		ArrayList<String> books = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(RESOURCE))) {

			while ((readeLine = br.readLine()) != null) {

				if (!readeLine.isBlank() && !readeLine.isEmpty()) {
					books.add(readeLine);
				}
			}

		} catch (IOException e) {

			throw new DAOException(e);
		}

		return books;

	}

	private List<String> delBook(List<String> books, Book book) {

		Iterator<String> iterator = books.iterator();
		String iteratorString;

		int beginIndex = 0;

		while (iterator.hasNext()) {

			iteratorString = iterator.next();

			if (!iteratorString.isBlank() && !iteratorString.isEmpty()) {

				if (book.getAuthor().equals(iteratorString.substring(beginIndex, iteratorString.indexOf(delimeter)))) {

					beginIndex = iteratorString.indexOf(delimeter) + 1;
					iteratorString = iteratorString.replaceFirst(delimeter, " ");

					if (book.getTitle()
							.equals(iteratorString.substring(beginIndex, iteratorString.indexOf(delimeter)))) {

						iterator.remove();
					}
				}

			}
		}

		return books;
	}

	private void writeBook(List<String> books) throws DAOException {

		File recourceFile = new File(RESOURCE);

		if (!recourceFile.delete()) {

			throw new DAOException("Error. File " + RESOURCE + " do not delete.");
		}

		writeBook(books.toArray(new String[books.size()]));
	}

	private void writeBook(String... strings) throws DAOException {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(RESOURCE, true))) {

			for (String string : strings) {

				bw.write(string);
				bw.newLine();
				bw.flush();
			}

		} catch (IOException e) {

			throw new DAOException(e);
		}

	}

}
