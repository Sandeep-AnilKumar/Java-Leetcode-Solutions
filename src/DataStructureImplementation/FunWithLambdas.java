package DataStructureImplementation;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunWithLambdas {

	public static void main(String[] args) {
		MathOp add = (x, y) -> x + y;
		MathOp subtract = (x, y) -> x - y;
		MathOp multiply = (x, y) -> x * y;
		MathOp divide = (x, y) -> x / y;
		MathOp min = Math::min;
		MathOp max = Math::max;

		int x = 100, y = 5;

		System.out.println(add.execute(x, y));
		System.out.println(subtract.execute(x, y));
		System.out.println(multiply.execute(x, y));
		System.out.println(divide.execute(x, y));
		System.out.println(min.execute(x, y));
		System.out.println(max.execute(x, y));

		int[] nums = {1, 2, 3, 4, 5};

		System.out.println(Arrays.stream(nums).map(FunWithLambdas::mapIntToMultiplesOf10).sum());

		Function<Integer, Integer> multiplyBy20 = (i -> i * 20);

		System.out.println(Arrays.stream(nums).map(multiplyBy20::apply).reduce(0, Integer::sum));

		Function<Integer, Integer> divideBy5 = (i -> i / 5);

		System.out.println(Arrays.stream(nums).map(multiplyBy20.andThen(divideBy5)::apply).sum());

		//Multiple ways of summing

		System.out.println(Arrays.stream(nums).map(FunWithLambdas::mapIntToMultiplesOf10).reduce(0, (i, j) -> i + j));

		System.out.println(Arrays.stream(nums).map(FunWithLambdas::mapIntToMultiplesOf10).reduce(0, Integer::sum));

		String[] s = {"Hi,    How     are youuuu?", "I am    doing   great", "     Do you want to   go   for a    movie?"};

		System.out.println(Arrays.stream(s).map(FunWithLambdas::preprocess).collect(Collectors.joining(" | ")));
	}

	private static int mapIntToMultiplesOf10(int x) {
		return x * 10;
	}

	private static String preprocess(String s) {
		return s.trim().replaceAll("\\s+", " ");
	}

	interface MathOp {
		int execute(int x, int y);
	}
}
