package by.htp.la.controller.impl;

import by.htp.la.controller.interf.Command;

public class WrongRequest implements Command{

	@Override
	public String execute(String request) {
		// TODO Auto-generated method stub
		return "Error. Wrong request.";
	}

}
