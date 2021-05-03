package by.htp.la.start;

import java.util.HashMap;
import java.util.Map;

public enum ChoiceAdmin implements Choice {

	SIGN_IN(-1), DELETE_USER(0), REGISTRATION(1), ADD_BOOK(11), FIND_BOOK(21), DELETE_BOOK(31), EDIT_BOOK(41);

	private int value;

	private static Map<Integer, ChoiceAdmin> map = new HashMap<>();

	static {
		for (ChoiceAdmin choiceEnum : ChoiceAdmin.values()) {
			map.put(choiceEnum.value, choiceEnum);
		}
	}

	private ChoiceAdmin(int value) {
		this.value = value;
	}

	public static ChoiceAdmin valueOf(int value) {
		
		if (value > 1 && value < 10) {

			value = 1;
		} else if (value > 11 && value < 20) {
			
			value = 11;
		}
		
		return map.get(value);
	}

	@Override
	public void getDescription() {
		// TODO Auto-generated method stub
		System.out.println("ChoiceAdmin");
		
	}

}
