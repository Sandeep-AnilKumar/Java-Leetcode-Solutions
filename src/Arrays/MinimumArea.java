package Arrays;

public class MinimumArea {

	public static void main(String[] args) {
		MinimumArea ma = new MinimumArea();
		char[][] image = {{'1','1','1','0'},
				{'1','0','1','1'},
				{'0','1','0','1'}};

		System.out.println("The minimum area enlcosing the black pixel is := " + ma.minArea(image, 0, 2));
	}

	public int minArea(char[][] image, int x, int y) {
		if(image == null || image.length == 0) {
			return 0;
		}

		int m = image.length;
		int n = image[0].length;

		int[] row = new int[m];
		int[] col = new int[n];

		for(int i = 0; i < m; ++i) {
			for(int j = 0; j < n; ++j) {
				if(image[i][j] == '1') {
					row[i]++;
					col[j]++;
				}
			}
		}

		int min = 0;
		int max = 0;
		int height = 0;
		int width = 0;
		boolean found = false;

		for(int i = 0; i < n; ++i) {
			if(col[i] != 0) {
				if(!found) {
					found = true;
					min = i;
					max = i;
				} else {
					max = i;
				}
			}
		}

		width = (max - min) + 1;
		min = 0;
		max = 0;
		found = false;

		for(int i = 0; i < m; ++i) {
			if(row[i] != 0) {
				if(!found) {
					found = true;
					min = i;
					max = i;
				} else {
					max = i;
				}
			}
		}

		height = (max - min) + 1;
		return width * height;
	}
}
