package DynamicProgramming;

public class ShipInDays {
	public static void main(String[] args) {
		ShipInDays shipInDays = new ShipInDays();
		int[] weights = {1, 2, 3, 1, 1};
		int D = 4;
		System.out.println("Minimum weight needed is := " + shipInDays.shipWithinDays(weights, D));
	}

	public boolean canShip(int[] weights, int D, int cap) {
		int cur = 0;
		int total = 1;
		for (int i = 0; i < weights.length; i++) {
			if (cur + weights[i] > cap) {
				total++;
				cur = 0;
			}
			cur += weights[i];
		}
		return total <= D;
	}

	public int shipWithinDays(int[] weights, int D) {
		int low = weights[0], high = 0;
		for (int i = 0; i < weights.length; i++) {
			low = Math.max(weights[i], low);
			high += weights[i];
		}
		while (low < high) {
			int mid = low + ((high - low) >>> 1);
			if (canShip(weights, D, mid)) high = mid;
			else low = mid + 1;
		}
		return low;
	}
}
