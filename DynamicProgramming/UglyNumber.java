package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UglyNumber {

	public static void main(String[] args)
	{
		int n = 10;
		int ugly = isUgly(n);
		System.out.println(" The "+ n +"th ugly number is " + ugly);
	}

	public static int isUgly(int num)
	{
		if (num <= 0)
			return 0;
		else if (num == 1)
			return 1;
		else
		{
			List<Integer> uglyArray = new ArrayList<>();
			boolean isUgly[] = new boolean[num*num];
			uglyArray.add(0);
			uglyArray.add(1);
			for(int i = 2; uglyArray.size()<=num; i++)
			{
				if(!isUgly[i])
				{
					int j = i;
					while(j % 2 == 0) j/=2;
					while(j % 3 == 0) j/=3;
					while(j % 5 == 0) j/=5;
					if(j == 1)
					{
						for(int k = i; uglyArray.size()<=num; k*=2)
						{
							if(!uglyArray.contains(k))
							{
								uglyArray.add(k);
								isUgly[k] = true;
							}
						}
					}
				}
			}
			return uglyArray.get(num);
		}
	}
}