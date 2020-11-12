import java.util.HashMap;
import java.util.List;

public class EmployeeImportanceUsingDFS {
	HashMap<Integer, Employee> map;
	int result = 0;

	public int getImportance(List<Employee> employees, int id) {

		map = new HashMap<Integer, Employee>();

		for (Employee e : employees) {
			map.put(e.id, e);
		}

		dfs(id);

		return result;
	}

	private void dfs(int id) {
		// TODO Auto-generated method stub

		// base
		// no need of base case bcoz the below for loop will take care of everything
		// i.e. it goes till depth of tree.

		// logic
		Employee eid = map.get(id);
		result += eid.importance;
		for (Integer empId : eid.subordinates)
			dfs(empId);
	}
}
