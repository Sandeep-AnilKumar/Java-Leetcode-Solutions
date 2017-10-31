package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author sandeepa
 */

public class FindLongestChain {

	public static void main(String[] args) {
		int[][] pairs = {{-6,9},{1,6},{8,10},{-1,4},{-6,-2},{-9,8},{-5,3},{0,3}};
		System.out.println("The length of the longest pair chain is := " + new FindLongestChain().findLongestChainBetter(pairs));
	}

	public int findLongestChain(int[][] pairs) {
		if(pairs == null || pairs.length == 0) return 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]));

		for(int[] pair: pairs) {
			pq.offer(pair);
		}

		int[] cur = new int[2];
		int[] prev = new int[2];
		int count = 0;
		List<int[]> chain = new ArrayList<>();
		while(!pq.isEmpty()) {
			cur = pq.poll();
			if(count == 0 || prev[1] < cur[0]) {
				count++;
				chain.add(cur);
				prev = cur;
			}
		}
		System.out.println("The chain formed is := ");
		for(int[] c: chain) {
			System.out.print("[");
			for(int ch: c) {
				System.out.print(ch + " ");
			}
			System.out.print("] -> ");
		}
		return count;
	}

	//Dp
	public int findLongestChainBetter(int[][] pairs) {
		int n  = pairs.length;
		Arrays.sort(pairs, (a , b)->{
			if(a[0] == b[0]){
				return a[1] - b[1];
			} else {
				return a[0] - b[0]; 
			}
		});  

		int[] dp = new int[n];
		Arrays.fill(dp, 1);

		for(int i = 0; i < n; i++){
			for(int j = 0; j < i; j++){
				if(pairs[j][1] < pairs[i][0]){
					dp[i] = Math.max(dp[i], dp[j] + 1); 
				}
			}
		}
		return dp[n - 1];
	}
}
