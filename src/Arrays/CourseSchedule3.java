package Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CourseSchedule3 {
	class Course {
		int num;
		int dur;

		public Course(int num, int dur) {
			this.num = num;
			this.dur = dur;
		}

		@Override
		public String toString() {
			return num + " -> " + dur; 
		}
	}

	public static void main(String[] args) {
		CourseSchedule3 cs = new CourseSchedule3();
		int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
		System.out.println("The number of courses that canShip be taken are := " + cs.scheduleCourse(courses));
	}

	public int scheduleCourse(int[][] courses) {
		PriorityQueue<Course> pq = new PriorityQueue<>(new Comparator<Course>() {
			public int compare(Course a, Course b) {
				return a.dur - b.dur;
			}
		});

		int i = 0;
		for(int[] co: courses) {
			pq.offer(new Course(i++, co[1] - co[0]));
		}

		int count = 0;
		int curDur = 0;
		Course cur = null;

		while(!pq.isEmpty()) {
			cur = pq.poll();
			curDur += courses[cur.num][0];
			if(courses[cur.num][1] >= curDur) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}
}