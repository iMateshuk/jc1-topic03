package by.htp.la.start;

import java.util.HashMap;
import java.util.Map;

public enum ChoiceAdult implements Choice {
	
	REGISTRATION(1), ADD_BOOK(11), FIND_BOOK(21), DELETE_BOOK(31), EDIT_BOOK(41);

	private int value;

	private static Map<Integer, ChoiceAdult> map = new HashMap<>();

	static {
		for (ChoiceAdult choiceEnum : ChoiceAdult.values()) {
			map.put(choiceEnum.value, choiceEnum);
		}
	}

	private ChoiceAdult(int value) {
		this.value = value;
	}

	public static ChoiceAdult valueOf(int value) {
		
		if (value > 1 && value < 3) {

			value = 1;
		} else if (value > 11 && value < 20) {
			
			value = 11;
		}
		return map.get(value);
	}

	@Override
	public void getDescription() {
		// TODO Auto-generated method stub
		System.out.println("ChoiceAdult");
	}

}
