package Arrays;
import java.util.List;
import java.util.ArrayList;

public class NgramsAsStrings {

	public static void main(String[] args) {
		char[] arr = {'a','b','c','d','e'}; 
		nGrams(arr);
	}

	public static List<String> nGrams(char[] arr)
	{
		List<String> combinations = new ArrayList<String>();
		if(arr.length == 0)
			return combinations;

		String c = "";
		combinations.add(c);

		for(int i = 0 ; i < arr.length; i++)
		{
			int size = combinations.size();

			for(int j = 0; j < size; j++)
			{
				String temp = combinations.get(j) + arr[i]; 

				if(!combinations.contains(temp))
					combinations.add(temp);
			}
		}
		return combinations;
	}
}
