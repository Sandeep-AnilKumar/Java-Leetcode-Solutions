package Arrays;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2 {

	public static void main(String[] args) {
		int prerequisites[][] = new int[][]{{1,0},{2,0},{3,1},{3,2}};
		int coursesToFinish = 4;
		boolean canFinish = canFinish(coursesToFinish, prerequisites);
		if(canFinish) {
			System.out.println("The courses can be finished, and the order is: -");
			int ordering[] = findOrder(coursesToFinish, prerequisites);
			for(int i = 0; i < ordering.length; i++) {
				System.out.print(ordering[i] + ", ");
			}
		}
		else {
			System.out.println("The courses cannot be finished");
		}
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		int length = prerequisites.length;
		int[] inDegree = new int[numCourses];

		for(int i = 0; i < length; ++i) {
			inDegree[prerequisites[i][0]]++;
		}

		Queue<Integer> queue = new LinkedList<Integer>();

		for(int i = 0; i < numCourses; ++i) {
			if(inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		int cur = 0;
		int count = 0;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			count++;
			for(int p[] : prerequisites) {
				if(p[1] == cur) {
					inDegree[p[0]]--;
					if(inDegree[p[0]] == 0) {
						queue.offer(p[0]);
					}
				}
			}
		}
		return count == numCourses ? true : false;
	}


	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] ordering = new int[numCourses];
		int length = prerequisites.length;
		int[] inDegree = new int[numCourses];

		for(int i = 0; i < length; ++i) {
			inDegree[prerequisites[i][0]]++;
		}

		Queue<Integer> queue = new LinkedList<Integer>();

		for(int i = 0; i < numCourses; ++i) {
			if(inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		int j = 0;
		int cur = 0;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			ordering[j++] = cur;

			for(int p[] : prerequisites) {
				if(p[1] == cur) {
					inDegree[p[0]]--;
					if(inDegree[p[0]] == 0) {
						queue.offer(p[0]);
					}
				}
			}
		}

		if(numCourses != j) {
			return new int[0];
		}
		return ordering;
	}
}
