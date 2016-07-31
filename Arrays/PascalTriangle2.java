package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle2 {

	public static void main(String[] args) {
		int num = 4;
		List<Integer>result = getRow(num);
		for(int n : result) {
			System.out.print(n + ",");
		}
	}

	public static List<Integer> generate(int rowIndex) {
		List<Integer> result = new ArrayList<>();  
		result.add(1);

		for(int i = 1; i <= rowIndex; ++i) {
			List<Integer> temp = new ArrayList<>();
			temp.add(1);

			List<Integer>sub = result;
			for(int j = 1; j < sub.size(); ++j) {
				temp.add(sub.get(j) + sub.get(j-1));
			}

			temp.add(1);
			result = new ArrayList<Integer>(temp);
		}
		return result;
	}

	//A better Solution, both in time and space.
	public static List<Integer> getRow(int k) {
		Integer[] arr = new Integer[k + 1];
		Arrays.fill(arr, 0);
		arr[0] = 1;

		for (int i = 1; i <= k; i++) 
			for (int j = i; j > 0; j--) 
				arr[j] = arr[j] + arr[j - 1];

		return Arrays.asList(arr);
	}
}
