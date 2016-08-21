package Arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PascalsTriangle {

	public static void main(String[] args) {
		int num = 10;
		List<List<Integer>> result = generate(num);

		System.out.println("The pascal's trianlge for n = "+ num + " is : \n[");
		for(int i = 0; i < result.size(); ++i)
		{
			String temp = "\t";
			for(int j = 0; j < num - i; ++j) {
				temp += "\b";
			}
			temp = temp.replaceAll("\b", " ");
			System.out.print(temp+"[");
			List<Integer> j = result.get(i);
			for(Iterator<Integer> r = j.iterator(); r.hasNext();)
				System.out.print(r.next() + " ");
			System.out.println("]");
		}
		System.out.println("]");
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		if(numRows <= 0) {
			return result;
		}   

		List<Integer> sub = new ArrayList<>();
		sub.add(1);
		result.add(sub);

		for(int i = 1; i < numRows; ++i) {
			List<Integer> temp = new ArrayList<>();
			temp.add(1);

			sub = new ArrayList<>(result.get(i-1));
			for(int j = 1; j < sub.size(); ++j) {
				temp.add(sub.get(j) + sub.get(j-1));
			}

			temp.add(1);
			result.add(temp);
		}
		return result;
	}
}