package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CutOffTrees {
	boolean complete = false;
	public static void main(String[] args) {
		CutOffTrees golf = new CutOffTrees();
		List<List<Integer>> forest = new ArrayList<>();
		List<Integer> row1 = Arrays.asList(new Integer[] {3,2,1});
		List<Integer> row2 = Arrays.asList(new Integer[] {5,0,0});
		List<Integer> row3 = Arrays.asList(new Integer[] {6,4,7});

		forest.add(row1);
		forest.add(row2);
		forest.add(row3);

		System.out.println("The number of steps required to cut off all the trees are := " + golf.cutOffTree(forest));
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
}
