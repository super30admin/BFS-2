import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Employee {
	public int id;
	public int importance;
	public List<Integer> subordinates;
}

public class EmployeeImportance {
	public int getImportanceUsingBFS(List<Employee> employees, int id) {

		if (employees == null || employees.size() == 0)
			return 0;
		HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
		for (Employee e : employees) {
			map.put(e.id, e);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(id);
		int result = 0;
		while (!q.isEmpty()) {
			int empId = q.poll();
			result += map.get(empId).importance;
			for (Integer sub : map.get(empId).subordinates) {
				q.add(sub);
			}

		}

		return result;

	}
}
