package Arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {

	public static void main(String[] args) {
		int prerequisites[][] = new int[][]{{1,0},{0,2},{3,1},{3,2}};
		int coursesToFinish = 4;
		//boolean canFinish = canFinish(coursesToFinish, prerequisites);
		//if(canFinish) {
		System.out.println("The courses can be finished, and the order is: -");
		int ordering[] = findOrder(coursesToFinish, prerequisites);
		for(int i = 0; i < ordering.length; i++) {
			System.out.print(ordering[i] + ", ");
		}
		//}
		//else {
		//System.out.println("The courses cannot be finished");
		//}
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

	//BFS Solution.
	public static int[] findOrderBFS(int numCourses, int[][] prerequisites) {
		int[] ordering = new int[numCourses];
		int length = prerequisites.length;
		int[] inDegree = new int[numCourses];

		for(int i = 0; i < length; ++i) {
			inDegree[prerequisites[i][0]]++;
		}

		Deque<Integer> queue = new ArrayDeque<Integer>();

		for(int i = 0; i < numCourses; ++i) {
			if(inDegree[i] == 0) {
				queue.addLast(i);
			}
		}

		int j = 0;
		int cur = 0;
		while(!queue.isEmpty()) {
			cur = queue.removeFirst();
			ordering[j++] = cur;

			for(int p[] : prerequisites) {
				if(p[1] == cur) {
					inDegree[p[0]]--;
					if(inDegree[p[0]] == 0) {
						queue.addLast(p[0]);
					}
				}
			}
		}

		if(numCourses != j) {
			return new int[0];
		}
		return ordering;
	}

	//DFS Solution

	public static int[] findOrderDFS(int numCourses, int[][] prerequisites) {
		int[] ordering = new int[numCourses];
		int[] inDegree = new int[numCourses];

		Deque<Integer> dq = new ArrayDeque<>();
		int length = prerequisites.length;

		for(int i = 0; i < length; ++i) {
			inDegree[prerequisites[i][0]]++;
		}

		for(int i = 0; i < numCourses; ++i) {
			if(inDegree[i] == 0) {
				dq.addFirst(i);
			}
		}

		boolean[] visited = new boolean[numCourses];
		int cur = 0;
		int count = 0;
		while(!dq.isEmpty()) {
			cur = dq.removeFirst();
			ordering[count++] = cur;

			for(int[] p : prerequisites) {
				if(p[1] == cur && !visited[cur]) {
					inDegree[p[0]]--;
					visited[cur] = true;

					if(inDegree[p[0]] == 0) {
						dq.addFirst(p[0]);
					}
				}
			}
		}

		if(count != numCourses) {
			return new int[0];
		}
		return ordering;
	}

	//Using OO concepts.

	private static int N = 0;

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		N = 0;
		int[] result = new int[numCourses];
		Course[] courses = new Course[numCourses];
		for (int i = 0; i < numCourses; i++) {
			courses[i] = new Course(i);
		}
		for (int i = 0; i < prerequisites.length; i++) {
			courses[prerequisites[i][0]].add(courses[prerequisites[i][1]]);
		}
		for (int i = 0; i < numCourses; i++) {
			if (isCyclic(courses[i], result)) {
				return new int[0];
			}
		}
		return result;
	}

	private static boolean isCyclic(Course cur, int[] result) {
		if (cur.tested == true) return false;
		if (cur.visited == true) return true;
		cur.visited = true;
		for (Course c : cur.pre) {
			if (isCyclic(c, result)) {
				return true;
			}
		}
		cur.tested = true;
		result[N++] = cur.number;
		return false;
	}

	static class Course {
		boolean visited = false;
		boolean tested = false;
		int number;
		List<Course> pre = new ArrayList<Course>();
		public Course(int i) {
			number = i;
		}
		public void add(Course c) {
			pre.add(c);
		}
	}
}
