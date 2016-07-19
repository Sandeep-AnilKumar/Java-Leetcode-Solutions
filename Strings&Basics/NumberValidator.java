package String;

import java.util.ArrayList;

interface NumberValidate {

	boolean validate(String s);
}

abstract class  NumberValidateTemplate implements NumberValidate {

	public boolean validate(String s) {
		if (checkStringEmpty(s)) {
			return false;
		}

		s = checkAndProcessHeader(s);

		if (s.length() == 0) {
			return false;
		}

		return doValidate(s);
	}

	private boolean checkStringEmpty(String s) {
		if (s.equals("")) {
			return true;
		}

		return false;
	}

	private String checkAndProcessHeader(String value) {
		value = value.trim();

		if (value.startsWith("+") || value.startsWith("-")) {
			value = value.substring(1);
		}
		return value;
	}

	protected abstract boolean doValidate(String s);
}

public class NumberValidator implements NumberValidate {

	public static void main(String[] args) {
		String s = "1234";
		System.out.println(isNumber(s));
	}

	private ArrayList<NumberValidate> validators = new ArrayList<NumberValidate>();

	public NumberValidator() {
		addValidators();
	}

	private  void addValidators() {
		NumberValidate nv = new IntegerValidate();
		validators.add(nv);

		nv = new FloatValidate();
		validators.add(nv);

		nv = new HexValidate();
		validators.add(nv);

		nv = new SienceFormatValidate();
		validators.add(nv);
	}

	@Override
	public boolean validate(String s) {
		for (NumberValidate nv : validators) {
			if (nv.validate(s) == true) {
				return true;
			}
		}

		return false;
	}


	public static boolean isNumber(String s) {
		NumberValidate nv = new NumberValidator();
		return nv.validate(s);
	}

}

class IntegerValidate extends NumberValidateTemplate {

	protected boolean doValidate(String integer) {
		for (int i = 0; i < integer.length(); i++) {
			if(Character.isDigit(integer.charAt(i)) == false) {
				return false;
			}
		}

		return true;
	}
}

class HexValidate extends NumberValidateTemplate {

	private char[] valids = new char[] {'a', 'b', 'c', 'd', 'e', 'f'};
	protected boolean doValidate(String hex) {
		hex = hex.toLowerCase();
		if (hex.startsWith("0x")) {
			hex = hex.substring(2);
		}
		else {
			return false;
		}

		for (int i = 0; i < hex.length(); i++) {
			if (Character.isDigit(hex.charAt(i)) != true && isValidChar(hex.charAt(i)) != true) {
				return false;
			}
		}

		return true;
	}

	private boolean isValidChar(char c) {
		for (int i = 0; i < valids.length; i++) {
			if (c == valids[i]) {
				return true;
			}
		}

		return false;
	}
}

class SienceFormatValidate extends NumberValidateTemplate {

	protected boolean doValidate(String s) {
		s = s.toLowerCase();
		int pos = s.indexOf("e");
		if (pos == -1) {
			return false;
		}

		if (s.length() == 1) {
			return false;
		}

		String first = s.substring(0, pos);
		String second = s.substring(pos+1, s.length());

		if (validatePartBeforeE(first) == false || validatePartAfterE(second) == false) {
			return false;
		}

		return true;
	}

	private boolean validatePartBeforeE(String first) {
		if (first.equals("") == true) {
			return false;
		}

		if (checkHeadAndEndForSpace(first) == false) {
			return false;
		}

		NumberValidate integerValidate = new IntegerValidate();
		NumberValidate floatValidate = new FloatValidate();
		if (integerValidate.validate(first) == false && floatValidate.validate(first) == false) {
			return false;
		}

		return true;
	}

	private boolean checkHeadAndEndForSpace(String part) {

		if (part.startsWith(" ") || part.endsWith(" ")) {
			return false;
		}

		return true;
	}

	private boolean validatePartAfterE(String second) {
		if (second.equals("") == true) {
			return false;
		}

		if (checkHeadAndEndForSpace(second) == false) {
			return false;
		}

		NumberValidate integerValidate = new IntegerValidate();
		if (integerValidate.validate(second) == false) {
			return false;
		}

		return true;
	}
}

class FloatValidate extends NumberValidateTemplate {

	protected boolean doValidate(String floatVal) {
		int pos = floatVal.indexOf(".");
		if (pos == -1) {
			return false;
		}

		if (floatVal.length() == 1) {
			return false;
		}

		String first = floatVal.substring(0, pos);
		String second = floatVal.substring(pos + 1, floatVal.length());

		if (checkFirstPart(first) == true && checkFirstPart(second) == true) {
			return true;
		}

		return false;
	}

	private boolean checkFirstPart(String first) {
		if (first.equals("") == false && checkPart(first) == false) {
			return false;
		}

		return true;
	}

	private boolean checkPart(String part) {
		if (Character.isDigit(part.charAt(0)) == false || Character.isDigit(part.charAt(part.length() - 1)) == false) {
			return false;
		}

		NumberValidate nv = new IntegerValidate();
		if (nv.validate(part) == false) {
			return false;
		}

		return true;
	}
}
