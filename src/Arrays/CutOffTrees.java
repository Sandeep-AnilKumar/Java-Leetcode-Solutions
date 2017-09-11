package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CutOffTrees {
	boolean complete = false;
	int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

	public static void main(String[] args) {
		CutOffTrees golf = new CutOffTrees();
		List<List<Integer>> forest = new ArrayList<>();
		List<Integer> row1 = Arrays.asList(new Integer[] {3,2,1});
		List<Integer> row2 = Arrays.asList(new Integer[] {5,0,0});
		List<Integer> row3 = Arrays.asList(new Integer[] {6,4,7});

		forest.add(row1);
		forest.add(row2);
		forest.add(row3);

		System.out.println("The number of steps required to cut off all the trees are := " + golf.cutOffTreeBetter(forest));
	}

	//works for numbers in a series, but a very wrong assumption from my end.
	public int cutOffTree(List<List<Integer>> forest) {
		if(forest == null || forest.size() == 0) return -1;
		int rows = forest.size();
		int cols = forest.get(0).size();
		boolean[][] visited = new boolean[rows][cols];

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int cur = 0;
		for(int i = 0; i < rows; ++i) {
			for(int j = 0; j < cols; ++j) {
				cur = forest.get(i).get(j);
				max = Math.max(max, cur);
				if(cur != 0 && cur != 1) {
					min = Math.min(min, cur);
				}
			}
		}

		int[] stats = {min, 0, 0, 0};

		int[] curStatus = getSteps(forest, 0, 0, stats, visited, max + 1);
		return curStatus[1];
	}

	public int[] getSteps(List<List<Integer>> forest, int row, int col, int[] stats, boolean[][] visited, int max) {
		if(row < 0 || row >= forest.size() || col < 0 || col >= forest.get(0).size() || visited[row][col]) {
			return new int[]{stats[0], -1, row, col};
		}

		if(stats[0] == max || complete) {
			complete = true;
			return stats;
		}

		if(forest.get(row).get(col) == 0) {
			visited[row][col] = true;
			return new int[]{stats[0], -1, row, col};
		}

		if(forest.get(row).get(col) == stats[0]) {
			stats[0]++;
			return getSteps(forest, row, col, stats, new boolean[forest.size()][forest.get(0).size()], max);
		}

		visited[row][col] = true;
		int[] tempStep = new int[] {stats[0], stats[1] + 1, stats[2], stats[3]};

		int[] top, bottom, left, right;
		top = bottom = left = right = new int[4];

		if(!complete) {
			top = getSteps(forest, row - 1, col, tempStep, visited, max);
		}

		if(!complete) {
			left = getSteps(forest, row, col - 1, tempStep, visited, max);
		}

		if(!complete) {
			right = getSteps(forest, row, col + 1, tempStep, visited, max);
		}

		if(!complete) {
			bottom = getSteps(forest, row + 1, col, tempStep, visited, max);
		}

		if(top[1] == -1 && left[1] == -1 && right[1] == -1 && bottom[1] == -1) {
			return new int[]{stats[0], -1, row, col};
		}

		int curStep = Integer.MAX_VALUE;

		if(top[1] != -1 && top[1] < curStep) {
			stats[1] = top[1];
			stats[2] = top[2];
			stats[3] = top[3];
		} else if(left[1] != -1 && left[1] < curStep) {
			stats[1] = left[1];
			stats[2] = left[2];
			stats[3] = left[3];
		} else if(right[1] != -1 && right[1] < curStep) {
			stats[1] = right[1];
			stats[2] = right[2];
			stats[3] = right[3];
		} else if(bottom[1] != -1 && bottom[1] < curStep) {
			stats[1] = bottom[1];
			stats[2] = bottom[2];
			stats[3] = bottom[3];
		}

		if(!complete) {
			stats[0]++;
			return getSteps(forest, stats[2], stats[3], stats, new boolean[forest.size()][forest.get(0).size()], max);
		} else {
			return stats;
		}
	}

	//Works for all cases.

	public int cutOffTreeBetter(List<List<Integer>> forest) {
		if (forest == null || forest.size() == 0) return -1;

		int m = forest.size(), n = forest.get(0).size(), res = 0;

		List<int[]> heights = new ArrayList<>();
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(forest.get(i).get(j) > 1) {
					heights.add( new int[]{forest.get(i).get(j), i, j} );
				}
			}
		}

		Collections.sort(heights, new Comparator<int[]>() {
			public int compare(int[] arr1, int[] arr2) {
				return Integer.compare(arr1[0], arr2[0]);
			}
		});

		//second step: accumulate the shortest steps between each two adajacent points in heights[].

		int start_x = 0, start_y = 0; 
		for(int i = 0; i<heights.size(); i++){
			int cnt_steps = BFS(forest, m, n, start_x, start_y, heights.get(i)[1], heights.get(i)[2]); 
			if(cnt_steps == -1)return -1;
			res += cnt_steps;
			start_x = heights.get(i)[1]; 
			start_y = heights.get(i)[2];
		}
		return res;
	}

	public int BFS(List<List<Integer>> forest, int m, int n, int start_x, int start_y, int des_x, int des_y){
		if(start_x == des_x && start_y == des_y)return 0;

		int steps = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{start_x, start_y});

		int[][] visited = new int[m][n];
		visited[start_x][start_y] = 1;

		while(!q.isEmpty()){
			int qsize = q.size();
			steps++;

			while(qsize-- >0 ){
				int[] cur = q.poll();
				int cur_x = cur[0], cur_y = cur[1];

				for(int k = 0; k<4; k++){
					int x = cur_x + dir[k][0], y = cur_y + dir[k][1];
					if(x >= 0 && x < m && y >= 0 && y < n && forest.get(x).get(y) > 0 && visited[x][y] == 0){
						if(x == des_x && y == des_y)return steps;
						visited[x][y] = 1;
						q.add(new int[]{x,y});
					}
				}
			}
		}
		return -1;
	}
}
