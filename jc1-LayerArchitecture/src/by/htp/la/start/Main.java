package by.htp.la.start;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import by.htp.la.bean.User;
import by.htp.la.controller.Controller;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		Controller controller = new Controller();

		String login = null;
		String password = null;

		String response = null;

		User user;

		String delimeter;

		do {

			delimeter = ":";

			login = scanUserData("Введите логин:", scanner);
			password = scanUserData("Введите пароль:", scanner);

			response = controller.executeTask(ChoiceAdmin.SIGN_IN + " " + login + " " + password);

			// System.out.println(response.toString());

			if (!response.matches(".*Error.*")) {

				String[] strings = response.split(delimeter);

				if (strings.length == 2) {

					user = new User.UserBuilder(strings[0], strings[1]).build();

				} else if (strings.length == 3) {

					user = new User.UserBuilder(strings[0], strings[1]).setAdult(strings[2].equals("true")).build();

				} else {

					user = new User.UserBuilder(strings[0], strings[1]).setAdult(strings[2].equals("true"))
							.setAdmin(strings[3].equals("true")).build();

				}

				System.out.println();
				System.out.println("Welcome! " + user.getLogin());
				System.out.println();

				break;
			}

			System.out.println();
			System.out.println(response);
			System.out.println();

		} while (true);

//////////success authorization

		delimeter = " ";
		int scannerNumber = 0;

		String taskString;
		Choice choice;

		String strDopParam = null;

		long id = 0;
		String title = null;
		String author = null;
		String bookStyle = null;
		boolean adultBook = false;
		boolean adultUser = false;
		boolean admin = false;

		do {

			List<String> booksChoice = new ArrayList<>();

			booksChoice.add("11 Добавить книгу (автор, название и жанр).");
			booksChoice.add("12 Добавить книгу (автор и название, но без жанра).");
			booksChoice.add("21 Найти книгу (автор и название).");

			if (user.isAdult() || user.isAdmin()) {

				List<String> usersChoice = new ArrayList<>();

				usersChoice.add("1 Добавить пользователя с ограниченными правами.");

				if (user.isAdmin()) {
					usersChoice.add("0 Удалить пользователя.");
					usersChoice.add("2 Добавить пользователя.");
					usersChoice.add("3 Добавить администратора.");
				}

				Collections.sort(usersChoice);

				System.out.println("Параметры пользователя:");
				printData(usersChoice);

				System.out.println();

				booksChoice.add("13 Добавить книгу для взрослых (без жанра).");
				booksChoice.add("31 Удалить книгу (автор и название).");
				booksChoice.add("41 Редактировать данные книги по ID.");
			}

			Collections.sort(booksChoice);

			System.out.println("Параметры библиотеки:");
			printData(booksChoice);

			System.out.println();
			System.out.println("99 Выход.");
			System.out.println();
			System.out.println("Введите число:");

			while (!scanner.hasNextInt()) {

				System.out.println("Нет. Введите число:");
				scanner.nextLine();
			}

			scannerNumber = scanner.nextInt();
			scanner.nextLine();

			if (scannerNumber == 99) { // Exit
				scanner.close();
				System.out.println();
				System.out.println("До свидания.");
				break;
			}

			if (user.isAdmin()) {

				choice = ChoiceAdmin.valueOf(scannerNumber);
			} else if (user.isAdult()) {

				choice = ChoiceAdult.valueOf(scannerNumber);
			} else {

				choice = ChoiceAny.valueOf(scannerNumber);
			}

			if (choice != null) {

				if (scannerNumber >= 0 && scannerNumber < 10) {

					if (scannerNumber == 2 || scannerNumber == 3) {

						adultUser = true;

						if (scannerNumber == 3) {

							admin = true;
						}

						strDopParam = Boolean.toString(adultUser) + " " + Boolean.toString(admin);
					}

					login = scanUserData("Введите логин:", scanner);
					password = scanUserData("Введите пароль:", scanner);
					taskString = choice + " " + login + " " + password;

					if (strDopParam != null) {

						taskString = taskString + " " + strDopParam;
					}

					response = controller.executeTask(taskString);

				} else if (scannerNumber > 10 && scannerNumber < 99) {

					if (scannerNumber == 12 || scannerNumber == 13) {

						bookStyle = "unknown";

						if (scannerNumber == 13) {

							adultBook = true;
						}

					}

					// author:title:id:adult:bookStyle
					author = scanUserData("Введите автора (без пробелов):", scanner);
					title = scanUserData("Введите название (без пробелов):", scanner);

					taskString = choice + " " + author + " " + title;

					if (!(scannerNumber == 21 || scannerNumber == 31)) {

						bookStyle = scanUserData("Название жанра(без пробелов):", scanner);

					}

					if (scannerNumber == 41) {

						while (true) {

							try {

								id = Long.parseLong(scanUserData("Введите ID:", scanner));
								break;

							} catch (NumberFormatException e) {
								System.out.println();
								System.out.println("Введено не число!");
								System.out.println();
							}

						}

					} else {

						id = 0;
					}

					taskString = taskString + " " + Long.toString(id) + " " + Boolean.toString(adultBook) + " "
							+ bookStyle;

					response = controller.executeTask(taskString);

					if (!(user.isAdult() || user.isAdmin())) {
						if (response.matches(".*:true:.*")) {
							response = "Книга не найдена.";
						}
					}

				}

			} else {

				response = "Введено не верное число!";
			}

			System.out.println();
			System.out.println(response);
			System.out.println();

		} while (true);

	}

	private static String scanUserData(String string, Scanner scanner) {

		System.out.println(string);
		return scanner.nextLine();

	}

	private static void printData(List<?> list) {

		for (Object object : list) {
			System.out.println(object);
		}
	}

}
