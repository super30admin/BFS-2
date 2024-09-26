
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

class Employee1 {
	public int id;
	public int importance;
	public List<Integer> subordinates;
}

public class Employee_Importance_DFS {
	Map<Integer, Employee> hmap;

	public int getImportance(List<Employee> employees, int id) {
		hmap = new HashMap<>();
		for (Employee emp : employees) {
			hmap.put(emp.id, emp);
		}
		return dfs(id);
	}

	public int dfs(int empid) {
		Employee employee = hmap.get(empid);
		int importance = employee.importance;
		for (int sub_id : employee.subordinates) {
			importance += dfs(sub_id);
		}
		return importance;
	}
}