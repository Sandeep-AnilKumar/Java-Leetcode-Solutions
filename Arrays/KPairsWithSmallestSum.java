package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class KPairsWithSmallestSum {

	public static void main(String[] args) {
		int[] nums1 = new int[]{1,7,11};
		int[] nums2 = new int[]{2,4,6};
		int k = 3;
		List<int[]> result = findKPairsWithSmallestSum(nums1, nums2, k);
		for(int[] nums : result) {
			System.out.print("[");
			for(int i = 0; nums != null && i < nums.length; ++i) {
				System.out.print(nums[i] + ",");
			}
			System.out.println("],");
		}
	}

	public static List<int[]> findKPairsWithSmallestSum(int[] nums1, int[] nums2, int k) {
		List<int[]> ret = new ArrayList<int[]>();
		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
			return ret;
		}

		int[] index = new int[nums1.length];
		while (k-- > 0) {
			int min_val = Integer.MAX_VALUE;
			int in = -1;
			for (int i = 0; i < nums1.length; i++) {
				if (index[i] >= nums2.length) {
					continue;
				}
				if (nums1[i] + nums2[index[i]] < min_val) {
					min_val = nums1[i] + nums2[index[i]];
					in = i;
				}
			}
			if (in == -1) {
				break;
			}
			int[] temp = {nums1[in], nums2[index[in]]};
			ret.add(temp);
			index[in]++;
		}
		return ret;
	}// Complexity O(k * m), m is the length of nums1.

	public static List<int[]> findKPairsWithSmallestSum1(int[] nums1, int[] nums2, int k) {

		List<int[]> result = new ArrayList<int[]>();
		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
			return result;
		}

		PriorityQueue<int[]> queue = new PriorityQueue<>((int[] a, int[] b) -> a[0]+a[1]-b[0]-b[1]);
		for(int i=0; i<nums1.length && i<k; i++) {
			queue.offer(new int[]{nums1[i], nums2[0], 0});
		}
		while(k-- > 0 && !queue.isEmpty()){
			int[] cur = queue.poll();
			result.add(new int[]{cur[0], cur[1]});
			if(cur[2] == nums2.length-1) continue;
			queue.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
		}
		return result;
	}//Complexity: - O(klogk);
}

/*
 * final int[][] neighbors = {{0, 1}, {1, 0}};
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) {
            return list;
        }
        int m = nums1.length, n = nums2.length;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> minHeap = new PriorityQueue<>();
        minHeap.offer(new Pair(0, 0, nums1[0] + nums2[0]));
        visited[0][0] = true;
        while (k > 0 && !minHeap.isEmpty()) {
            Pair min = minHeap.poll();
            list.add(new int[] {nums1[min.row], nums2[min.col]});
            k--;
            for (int[] neighbor : neighbors) {
                int row1 = min.row + neighbor[0];
                int col1 = min.col + neighbor[1];
                if (row1 < 0 || row1 == m || col1 < 0 || col1 == n || visited[row1][col1]) {
                    continue;
                }
                visited[row1][col1] = true;
                minHeap.offer(new Pair(row1, col1, nums1[row1] + nums2[col1]));
            }
        }
        return list;
    }
}

class Pair implements Comparable<Pair> {
    int row;
    int col;
    int value;

    Pair(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public int compareTo(Pair other) {
        return value - other.value;
    } 
 * 
 * */
