package by.htp.la.start;

import java.util.HashMap;
import java.util.Map;

public enum Choice {

	SIGN_IN(-1), DELETE_USER(0), REGISTRATION(1), ADD_BOOK(11), DELETE_BOOK(21), FIND_BOOK(31), EDIT_BOOK(41);

	private int value;

	private static Map<Integer, Choice> map = new HashMap<>();

	static {
		for (Choice choiceEnum : Choice.values()) {
			map.put(choiceEnum.value, choiceEnum);
		}
	}

	private Choice(int value) {
		this.value = value;
	}

	public static Choice valueOf(int value) {
		return map.get(value);
	}

}
