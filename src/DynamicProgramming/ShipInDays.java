package DynamicProgramming;

public class ShipInDays {
	public static void main(String[] args) {
		ShipInDays shipInDays = new ShipInDays();
		int[] weights = {1, 2, 3, 1, 1};
		int D = 4;
		System.out.println("Minimum weight needed is := " + shipInDays.shipWithinDays(weights, D));
	}

	public boolean can(int[] weights, int D, int cap) {
		int cd = 0;
		int ans = 1;
		for (int i = 0; i < weights.length; i++) {
			if (cd + weights[i] > cap) {
				ans++;
				cd = 0;
			}
			cd += weights[i];
		}
		return ans <= D;
	}

	public int shipWithinDays(int[] weights, int D) {
		int lo = weights[0], hi = 0;
		for (int i = 0; i < weights.length; i++) {
			lo = Math.max(weights[i], lo);
			hi += weights[i];
		}
		while (lo < hi) {
			int mid = (hi + lo) / 2;
			if (can(weights, D, mid)) hi = mid;
			else lo = mid + 1;
		}
		return lo;
	}
}
