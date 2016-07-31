package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UglyNumber {

	public static void main(String[] args)
	{
		int n = 10;
		int ugly = nthUglyNumber(12);
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
	}// bad version.

	//A better one.

	public static int nthUglyNumber(int n) {
		int[] ugly = new int[n];
		ugly[0] = 1;
		int index2 = 0, index3 = 0, index5 = 0;
		int factor2 = 2, factor3 = 3, factor5 = 5;
		for(int i=1;i<n;i++){
			int min = Math.min(Math.min(factor2,factor3),factor5);
			ugly[i] = min;
			if(factor2 == min)
				factor2 = 2*ugly[++index2];
			if(factor3 == min)
				factor3 = 3*ugly[++index3];
			if(factor5 == min)
				factor5 = 5*ugly[++index5];
		}
		return ugly[n-1];
	}

}