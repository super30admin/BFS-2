
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

class Employee {
	public int id;
	public int importance;
	public List<Integer> subordinates;
}

public class Employee_importance_BFS {
	public int getImportance(List<Employee> employees, int id) {
		HashMap<Integer, Employee> emap = new HashMap<>();
		for (Employee emp : employees) {
			emap.put(emp.id, emp);
		}
		Queue<Employee> q = new LinkedList<>();
		q.add(emap.get(id));
		int imp = 0;
		while (q.size() > 0) {
			Employee emp = q.poll();
			imp += emp.importance;
			for (int sub_id : emp.subordinates) {
				q.add(emap.get(sub_id));
			}
		}
		return imp;
	}
}