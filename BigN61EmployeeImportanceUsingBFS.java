// Time complexity is O(N).
// Space complexity is O(n+n) = O(2n) = O(n) i.e for hashmap and queue data structure
// This solution is submitted on leetcode

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BigN61EmployeeImportanceUsingBFS {
//Employee info
	class Employee {
		// It's the unique id of each node;
		// unique id of this employee
		public int id;
		// the importance value of this employee
		public int importance;
		// the id of direct subordinates
		public List<Integer> subordinates;
	};

	class Solution {
		public int getImportance(List<Employee> employees, int id) {
			int result = 0;
			// edge case:
			if (employees == null || employees.size() == 0 || id == 0)
				return result;
			HashMap<Integer, Employee> map = new HashMap<>();
			for (Employee e : employees) {
				map.put(e.id, e);
			}
			Queue<Integer> q = new LinkedList<>();
			q.add(id);
			while (!q.isEmpty()) {
				int empId = q.poll();
				Employee emp = map.get(empId);
				result += emp.importance;
				for (int subid : emp.subordinates)
					q.add(subid);
			}
			return result;
		}
	}
}