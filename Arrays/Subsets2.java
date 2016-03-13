package Arrays;
import java.util.List;
import java.util.ArrayList;

public class Ngrams {

	public static void main(String[] args) {
		char[] arr = {'a','b','c','d','e'}; 
		nGrams(arr);
	}

	public static List<List<String>> nGrams(char[] arr)
	{
		List<List<String>> combinations = new ArrayList<List<String>>();
		if(arr.length == 0)
			return combinations;

		List<String> subsets = new ArrayList<String>();
		combinations.add(subsets);

		for(int i = 0 ; i < arr.length; i++)
		{
			int size = combinations.size();

			for(int j = 0; j < size; j++)
			{
				List<String> temp = new ArrayList<String>(combinations.get(j));
				String toAdd = String.valueOf(arr[i]); 
				temp.add(toAdd);

				if(!combinations.contains(temp))
					combinations.add(temp);
			}
		}
		return combinations;
	}
}
