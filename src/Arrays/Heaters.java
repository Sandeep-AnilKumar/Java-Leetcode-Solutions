package Arrays;

import java.util.Arrays;

public class Heaters {

	public static void main(String[] args) {
		Heaters heater = new Heaters();
		int[] houses = {1, 23, 70};
		int[] heaters = {9, 41};
		System.out.println("The minimum heater radius to warm all the heaters is := " + heater.findRadius(houses, heaters));
	}

	//O(m * n), where m is the number of houses, n is the number of heaters.
	public int findRadius(int[] houses, int[] heaters) {
		if(houses == null || houses.length == 0 || heaters == null || heaters.length == 0) return 0;

		Arrays.sort(houses);
		Arrays.sort(heaters);

		int num_houses = houses.length;
		int num_heaters = heaters.length;
		int max_radius = 0;
		int min_house_radius = 0;

		for(int i = 0; i < num_houses; ++i) {
			min_house_radius = Integer.MAX_VALUE;
			for(int j = 0; j < num_heaters; ++j) {
				min_house_radius = Math.min(Math.abs(houses[i] - heaters[j]), min_house_radius);
			}
			max_radius = Math.max(max_radius, min_house_radius);
		}
		return max_radius;
	}
}
