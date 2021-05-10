package by.htp.la.controller;

import java.util.HashMap;
import java.util.Map;

import by.htp.la.controller.impl.AddBook;
import by.htp.la.controller.impl.DeleteBook;
import by.htp.la.controller.impl.DeleteUser;
import by.htp.la.controller.impl.EditBook;
import by.htp.la.controller.impl.FindBook;
import by.htp.la.controller.impl.Rregistration;
import by.htp.la.controller.impl.SingIn;
import by.htp.la.controller.impl.WrongRequest;
import by.htp.la.controller.interf.Command;
import by.htp.la.util.LogWriter;

public class CommandProvider {

	private final Map<CommandName, Command> repository = new HashMap<>();

	CommandProvider() {
		repository.put(CommandName.SIGN_IN, new SingIn());
		repository.put(CommandName.REGISTRATION, new Rregistration());
		repository.put(CommandName.ADD_BOOK, new AddBook());
		repository.put(CommandName.FIND_BOOK, new FindBook());
		repository.put(CommandName.DELETE_BOOK, new DeleteBook());
		repository.put(CommandName.EDIT_BOOK, new EditBook());
		repository.put(CommandName.DELETE_USER, new DeleteUser());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
	}

	Command getCommand(String name) {

		CommandName commandName = null;
		Command command = null;

		try {
			
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);

		} catch (IllegalArgumentException | NullPointerException e) {
			// write log !!!!
			LogWriter.writeLog(e);
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		
		return command;

	}

}
