package by.htp.la.start;

import java.util.Scanner;

import by.htp.la.bean.User;
import by.htp.la.bean.UserBuilder;
import by.htp.la.controller.Controller;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		Controller controller = new Controller();

		String login = null;
		String password = null;

		String response = null;

		do {
			login = scanUserData("Введите логин:", scanner);
			password = scanUserData("Введите пароль:", scanner);

			response = controller.executeTask(Choice.SIGN_IN + " " + login + " " + password);

			// System.out.println(response.toString());

			if (!response.matches(".*Error.*")) {
				System.out.println();
				break;
			}

			System.out.println();
			System.out.println(response);
			System.out.println();

		} while (true);

		String delimeter = ":";

		String[] strings = response.split(delimeter);

		User user;

		if (strings.length == 2) {

			user = new UserBuilder(strings[0], strings[1]).build();

		} else if (strings.length == 3) {

			user = new UserBuilder(strings[0], strings[1]).setAdult(strings[2].equals("true")).build();

		} else {

			user = new UserBuilder(strings[0], strings[1]).setAdult(strings[2].equals("true"))
					.setAdmin(strings[3].equals("true")).build();

		}

		System.out.println("Welcome! " + user.getLogin());
		System.out.println();

		delimeter = " ";
		int scannerNumber = 0;

		String taskString;
		Choice choice;

		boolean adultUser = false;
		boolean admin = false;
		String strDopParam = null;

		// long id = 0;
		String title = null;
		String author = null;
		String bookStyle = null;
		boolean adultBook = false;

		do {
			System.out.println("Параметры пользователя:");
			System.out.println("0 Удалить пользователя.");
			System.out.println("1 Добавить ребенка.");
			System.out.println("2 Добавить взрослого.");
			System.out.println("3 Добавить администратора.");
			System.out.println();
			System.out.println("Параметры библиотеки:");
			System.out.println("11 Добавить книгу.");
			System.out.println("12 Добавить книгу без стиля.");
			System.out.println("13 Добавить книгу для взрослых.");
			System.out.println("21 Удалить книгу.");
			System.out.println("31 Найти книгу.");
			System.out.println("41 Редактировать данные книги.");
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

			adultUser = false;
			admin = false;
			strDopParam = null;

			// long id = 0;
			title = null;
			author = null;
			bookStyle = null;
			adultBook = false;

			if (scannerNumber >= 2 && scannerNumber <= 3) {
				adultUser = true;
				scannerNumber--;
				if (scannerNumber == 2) {
					admin = true;
					scannerNumber--;
				}

				strDopParam = Boolean.toString(adultUser) + " " + Boolean.toString(admin);
			}

			if (scannerNumber >= 12 && scannerNumber <= 13) {

				bookStyle = "unknown";
				scannerNumber--;

				if (scannerNumber == 12) {

					adultBook = true;
					scannerNumber--;
				}
			}

			if ((choice = Choice.valueOf(scannerNumber)) != null) {

				if (scannerNumber > 0 && scannerNumber < 10 && user.isAdmin()) {

					login = scanUserData("Введите логин:", scanner);
					password = scanUserData("Введите пароль:", scanner);
					taskString = choice + " " + login + " " + password;

					if (strDopParam != null) {

						taskString = taskString + " " + strDopParam;
					}

					response = controller.executeTask(taskString);

				} else if (scannerNumber > 10 && scannerNumber < 99) {

					// author:title:id:adult:bookStyle
					author = scanUserData("Введите автора (без пробелов):", scanner);
					title = scanUserData("Введите название (без пробелов):", scanner);

					taskString = choice + " " + author + " " + title;

					if (!(scannerNumber == 21 || scannerNumber == 31)) {

						if (!bookStyle.equals("unknown")) {
							bookStyle = scanUserData("Название стиля(без пробелов):", scanner);
						}

						taskString = taskString + " " + Long.toString(((long) Math.random() * 100)) + " "
								+ Boolean.toString(adultBook) + " " + bookStyle;
					}

					response = controller.executeTask(taskString);

				} else {

					response = badUserAttribute(user);
				}

			} else {

				response = choice + ", введено не верное число !";
			}

			System.out.println();
			System.out.println(response);
			System.out.println();

		} while (true);

	}

	public static String scanUserData(String string, Scanner scanner) {

		System.out.println(string);
		return scanner.nextLine();

	}

	public static String badUserAttribute(User user) {

		return "Нет нужных прав " + user.getLogin() + ": isAdmin - " + user.isAdmin() + ", isAdult - " + user.isAdult();
	}

}
