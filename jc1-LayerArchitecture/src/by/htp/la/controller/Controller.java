package by.htp.la.controller;

import by.htp.la.controller.interf.Command;

public class Controller {

	private final CommandProvider provider = new CommandProvider();
	private final char paramDelimeter = ' ';
	private final String stringDelimeter = " ";

	public String executeTask(String request) {

		if (request == null || request.split(stringDelimeter).length < 3) {
			
			return "Error. Controller. Request is wrong.";
		}

		String commandName;
		Command executionCommand;

		commandName = request.substring(0, request.indexOf(paramDelimeter));
		executionCommand = provider.getCommand(commandName);

		String response;

		response = executionCommand.execute(request);

		return response;
	}

}
