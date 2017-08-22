package Arrays;

public class CanPlaceFlowers {

	public static void main(String[] args) {
		CanPlaceFlowers cp = new CanPlaceFlowers();
		int[] flowerbed = {1,0,0,0,0,1};
		int n = 2;
		System.out.println(cp.canPlaceFlowers(flowerbed, n));
	}

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int length = flowerbed.length;

		for(int i = 0; i < length; i++) {
			if(flowerbed[i] == 0) {
				if(i == 0) {
					if((i == length - 1) || (i <= length - 2 && flowerbed[i + 1] == 0)) {
						n -= 1;
						flowerbed[i] = 1;
					}
				}
				else if ((i >= 1 && flowerbed[i - 1] == 0) && (i <= length - 2 && flowerbed[i + 1] == 0)) {
					n -= 1;
					flowerbed[i] = 1;
				} else if(i == length - 1 && flowerbed[i - 1] == 0) {
					n -= 1;
					flowerbed[i] = 1;
				}
			}
		}
		return n <= 0;
	}
}
