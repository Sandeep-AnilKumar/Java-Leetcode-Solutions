package Arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseComplete {

	public static void main(String[] args) {
		CourseComplete course = new CourseComplete();
		int numCourses = 4;
		int[][] prerequisites = {{1,0},{0,1}};
		System.out.println("Can you finish the courses with the given prerequisites ? := " + course.canFinish(numCourses, prerequisites));
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] counts = new int[numCourses];
		Deque<Integer> completed = new ArrayDeque<>();
		Map<Integer, List<Integer>> dependence = new HashMap<>();
		List<Integer> dependents = new ArrayList<>();

		for(int[] course: prerequisites) {
			if(!dependence.containsKey(course[1])) {
				dependents = new ArrayList<>();
				dependents.add(course[0]);
				dependence.put(course[1], dependents);
			} else {
				dependence.get(course[1]).add(course[0]);
			}
			counts[course[0]]++;
		}

		int count = 0;

		for(int i = 0; i < numCourses; ++i) {
			if(counts[i] == 0) completed.offer(i);
		}

		int curCompleted = 0;
		while(!completed.isEmpty()) {
			curCompleted = completed.poll();
			count++;

			dependents = dependence.get(curCompleted);
			if(dependents != null && dependents.size() > 0) {
				for(int dependent: dependents) {
					counts[dependent]--;
					if(counts[dependent] == 0) {
						completed.offer(dependent);
					}
				}
				dependence.remove(curCompleted);
			}
		}
		return count == numCourses;
	}
}
