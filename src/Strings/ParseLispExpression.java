package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParseLispExpression {
	public static void main(String[] args) {
		ParseLispExpression parseLispExpression = new ParseLispExpression();

		String expression = "(add 1 2)";
		System.out.println(parseLispExpression.evaluate(expression));

		expression = "(mult 3 (add 2 3))";
		System.out.println(parseLispExpression.evaluate(expression));

		expression = "(let x 2 (mult x 5))";
		System.out.println(parseLispExpression.evaluate(expression));

		expression = "(let x 2 (mult x (let x 3 y 4 (add x y))))";
		System.out.println(parseLispExpression.evaluate(expression));

		expression = "(let x 3 x 2 x)";
		System.out.println(parseLispExpression.evaluate(expression));

		expression = "(let x 1 y 2 x (add x y) (add x y))";
		System.out.println(parseLispExpression.evaluate(expression));

		expression = "(let x 2 (add (let x 3 (let x 4 x)) x))";
		System.out.println(parseLispExpression.evaluate(expression));

		expression = "(mult 3 (add 2 3))";
		System.out.println(parseLispExpression.evaluate(expression));

		expression = "(let a1 3 b2 (add a1 1) b2)";
		System.out.println(parseLispExpression.evaluate(expression));
	}

	public int evaluate(String expression) {
		return eval(expression, new HashMap<>());
	}

	private int eval(String exp, Map<String, Integer> parent) {
		if (exp.charAt(0) != '(') {

			if (Character.isDigit(exp.charAt(0)) || exp.charAt(0) == '-')
				return Integer.parseInt(exp);
			return parent.get(exp);
		}


		Map<String, Integer> map = new HashMap<>(parent);

		List<String> tokens = parse(exp.substring(exp.charAt(1) == 'm' ? 6 : 5, exp.length() - 1));
		if (exp.startsWith("(a")) {
			return eval(tokens.get(0), map) + eval(tokens.get(1), map);

		} else if (exp.startsWith("(m")) {
			return eval(tokens.get(0), map) * eval(tokens.get(1), map);

		} else {
			for (int i = 0; i < tokens.size() - 2; i += 2)
				map.put(tokens.get(i), eval(tokens.get(i + 1), map));
			return eval(tokens.get(tokens.size() - 1), map);
		}
	}

	private List<String> parse(String str) {

		List<String> res = new ArrayList<>();
		int par = 0;
		StringBuilder sb = new StringBuilder();

		for (char c : str.toCharArray()) {
			if (c == '(') par++;
			if (c == ')') par--;
			if (par == 0 && c == ' ') {
				res.add(new String(sb));
				sb = new StringBuilder();
			} else {
				sb.append(c);
			}
		}

		if (sb.length() > 0) res.add(new String(sb));
		return res;
	}
}
