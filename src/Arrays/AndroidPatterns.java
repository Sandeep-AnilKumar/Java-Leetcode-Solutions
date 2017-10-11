package Arrays;

public class AndroidPatterns {

	public static void main(String[] args) {
		int m = 2;
		int n = 2;
		System.out.println("Total number of possible options is := " + new AndroidPatterns().numberOfPatterns(m, n));
	}

	int[] nexts = {-2, -1, 0, 1, 2};

	public int numberOfPatterns(int m, int n) {
		int count = 0;
		boolean[][] visited = new boolean[3][3];

		for(int keys = m; keys <= n; ++keys){
			for(int i = 0; i < 3; ++i) {
				for(int j = 0; j < 3; ++j) {
					visited = new boolean[3][3];
					count += getPatterns(i, j, 1, keys, visited);
				}
			}
		}
		return count;
	}

	public int getPatterns(int i, int j, int curKeys, int keys, boolean[][] visited) {
		if(i < 0 || j < 0 || i >= 3 || j >= 3 || visited[i][j]) return 0;

		if(curKeys == keys) return 1;

		int count = 0;
		visited[i][j] = true;

		for(int k = 0; k < 5; ++k) {
			for(int l = 0; l < 5; ++l) {
				if((k == 0 && l == 0) || (k == 0 && l == 2) || (k == 2 && l == 0) || (k == 2 && l == 2) || (k == 4 && l == 4) || (k == 4 && l == 2) || (k == 4 && l == 0) || (k == 2 && l == 4) || (k == 0 && l == 4)) continue;

				count += getPatterns(i + nexts[k], j + nexts[l], curKeys + 1, keys, visited);
			}
		}

		visited[i][j] = false;
		return count;
	}
}