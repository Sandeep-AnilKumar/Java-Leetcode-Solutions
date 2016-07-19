package Arrays;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2 {

	public static void main(String[] args) {
		int prerequisites[][] = new int[][]{{1,0},{2,0}};
		int ordering[] = findOrdering(3, prerequisites);
		for(int i = 0; i < ordering.length; i++) {
			System.out.println(ordering[i]);
		}
	}

	public static int[] findOrdering(int numCourses, int[][] prerequisites) {
		int ordering[] = new int[numCourses];
		if(numCourses <= 0) {
			return ordering;
		}

		if(prerequisites == null) {
			return ordering;
		}

		int preLength = prerequisites.length;
		if(preLength == 0)
			return ordering;

		int inDegree[] = new int[numCourses];
		Queue<Integer> queue = new LinkedList<Integer>();

		for(int i = 0; i < preLength; i++) {
			if(!(prerequisites[i][1] > numCourses - 1)) {
				inDegree[prerequisites[i][1]]++;
			}
		}

		for(int i = 0; i < numCourses; i++) {
			if(inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		int x = 0;
		int j = 0;
		while(!queue.isEmpty()) {
			x = queue.poll();
			for(int i = 0; i < preLength; i++) {
				if(x == prerequisites[i][0]) {
					inDegree[prerequisites[i][1]]--;
					if(inDegree[prerequisites[i][1]] == 0) {
						queue.offer(prerequisites[i][1]);
					}
				}
			}
			ordering[j] = x;
			j++;
		}

		int emptyArray[] = new int[numCourses];
		for(int i = 0; i < numCourses; i++) {
			if(inDegree[i] != 0) {
				return emptyArray;
			}
		}
		return ordering;
	}

}
