package Arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

/**
 * @author sandeepa
 */

public class EmployeeImportance {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		//[[1,5,[2,3]],[2,3,[4]],[3,4,[]],[4,1,[]]], 1
		employees.add(new Employee(1, 5, Arrays.asList(2, 3)));
		employees.add(new Employee(2, 3, Arrays.asList(4)));
		employees.add(new Employee(3, 4, null));
		employees.add(new Employee(4, 1, null));

		int id = 1;

		System.out.println("The total importance of an employee with id := " + id + " is :=" + new EmployeeImportance().getImportance(employees, id));
	}

	static class Employee {
		// It's the unique id of each node;
		// unique id of this employee
		public int id;
		// the importance value of this employee
		public int importance;
		// the id of direct subordinates
		public List<Integer> subordinates;

		public Employee(int id, int importance, List<Integer> subordinates) {
			this.id = id;
			this.importance = importance;
			this.subordinates = subordinates;
		}

	}

	public int getImportance(List<Employee> employees, int id) {
		if(employees == null || employees.size() == 0) return 0;

		Map<Integer, Employee> map = new HashMap<>();

		for(Employee employee: employees) {
			map.put(employee.id, employee);
		}

		int value = 0, cur = 0;
		Deque<Integer> subs = new ArrayDeque<>();

		subs.offer(id);

		while(!subs.isEmpty()) {
			cur = subs.poll();
			value += map.get(cur).importance;
			if(map.get(cur).subordinates != null) {
				for(int subordinate: map.get(cur).subordinates) {
					subs.offer(subordinate);
				}
			}
		}
		return value;
	}
}
