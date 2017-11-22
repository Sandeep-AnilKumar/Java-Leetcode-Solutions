package Strings;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author sandeepa
 */

public class NumberOfAtoms {

	public static void main(String[] args) {
		NumberOfAtoms atoms = new NumberOfAtoms();
		String formula = "K4(ON(SO3)2)2";
		//		System.out.println("The number of atoms in the chemical formula is := " + atoms.countOfAtoms(formula));
		//
		//		formula = "H2O";
		//		System.out.println("The number of atoms in the chemical formula is := " + atoms.countOfAtoms(formula));
		//
		//		formula = "Mg(OH)2";
		//		System.out.println("The number of atoms in the chemical formula is := " + atoms.countOfAtoms(formula));
		//
		//		formula = "(H2O2)";
		//		System.out.println("The number of atoms in the chemical formula is := " + atoms.countOfAtoms(formula));
		//
		//		formula = "((HHe28Be26He)9)34";
		//		System.out.println("The number of atoms in the chemical formula is := " + atoms.countOfAtoms(formula));
		//
		//		formula = "(Db40Hs6Sc10I28IrBe22)8((Np25Lu36Ge46)46(Ta28Lv16Fe38Sn11PbCa23Ta37)26(Li35Hf11I38Po43Sg10Tl19BrZn24)19(Au3CePa23Ac36Hs7Es35AlTlGdRa7)34(Nb38Cu7Cd14)16)13";
		//		System.out.println("The number of atoms in the chemical formula is := " + atoms.countOfAtoms(formula));

		formula = "((A2)24(B)33(C)21(D5)15(E5)16)1";
		System.out.println("The number of atoms in the chemical formula is := " + atoms.countOfAtoms(formula));
	}

	public String countOfAtoms(String formula) {
		int N = formula.length();
		Stack<Map<String, Integer>> stack = new Stack<>();
		stack.push(new TreeMap<String, Integer>());

		for (int i = 0; i < N;) {
			if (formula.charAt(i) == '(') {
				stack.push(new TreeMap<String, Integer>());
				i++;
			} else if (formula.charAt(i) == ')') {
				Map<String, Integer> top = stack.pop();
				int iStart = ++i, multiplicity = 1;
				while (i < N && isNumber(formula.charAt(i))) i++;
				if (i > iStart) multiplicity = Integer.parseInt(formula.substring(iStart, i));
				for (String c: top.keySet()) {
					int v = top.get(c);
					stack.peek().put(c, stack.peek().getOrDefault(c, 0) + v * multiplicity);
				}
			} else {
				int iStart = i++;
				while (i < N && isLowerCase(formula.charAt(i))) i++;
				String name = formula.substring(iStart, i);
				iStart = i;
				while (i < N && isNumber(formula.charAt(i))) i++;
				int multiplicity = i > iStart ? Integer.parseInt(formula.substring(iStart, i)) : 1;
				stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multiplicity);
			}
		}

		StringBuilder ans = new StringBuilder();
		for (String name: stack.peek().keySet()) {
			ans.append(name);
			int multiplicity = stack.peek().get(name);
			if (multiplicity > 1) ans.append("" + multiplicity);
		}
		return new String(ans);
	}

	public boolean isUpperCase(char c) {
		int ascii = (int) c;

		return ascii >= 65 && ascii <= 90;
	}

	public boolean isLowerCase(char c) {
		int ascii = (int) c;

		return ascii >= 97 && ascii <= 122;
	}

	public boolean isNumber(char c) {
		int ascii = (int) c;

		return ascii >= 48 && ascii <= 57;
	}
}