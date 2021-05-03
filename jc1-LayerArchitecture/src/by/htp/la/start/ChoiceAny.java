package by.htp.la.start;

import java.util.HashMap;
import java.util.Map;

public enum ChoiceAny implements Choice {

	ADD_BOOK(11), FIND_BOOK(21);

	private int value;

	private static Map<Integer, ChoiceAny> map = new HashMap<>();

	static {
		for (ChoiceAny choiceEnum : ChoiceAny.values()) {
			map.put(choiceEnum.value, choiceEnum);
		}
	}

	private ChoiceAny(int value) {
		this.value = value;
	}

	public static ChoiceAny valueOf(int value) {

		if (value == 12) {

			value = 11;
		}
		return map.get(value);
	}

	@Override
	public void getDescription() {
		// TODO Auto-generated method stub
		System.out.println("ChoiceAny");
	}

}
