
// Time Complexity :
// Space Complexity : 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

class Employee {
	// It's the unique id of each node;
	// unique id of this employee
	public int id;
	// the importance value of this employee
	public int importance;
	// the id of direct subordinates
	public List<Integer> subordinates;
}


public class EmployeeImportanceDFS {

	Map<Integer, Employee> map = new HashMap<>();
	int importance = 0;
	
	private int getImportance(List<Employee> employees, int id) {
		
		for(Employee e : employees) {
			map.put(e.id, e);
		}
		dfs(id);
		return importance;
		
	}
	
	private void dfs(int id) {
		
		Employee e = map.get(id);
		importance = importance + e.importance;
		List<Integer> subordinates = e.subordinates;
		for(int subs : subordinates) {
			dfs(subs);
		}

	}
	
	
	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.id = 1;
		e1.importance = 5;
		e1.subordinates = new ArrayList<>(Arrays.asList(2, 3));
		
		
		Employee e2 = new Employee();
		e2.id = 2;
		e2.importance = 3;
		e2.subordinates = new ArrayList<>(Arrays.asList(3));
		
		Employee e3 = new Employee();
		e3.id = 3;
		e3.importance = 3;
		e3.subordinates = new ArrayList<>();
		
		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
				
		EmployeeImportanceDFS e = new EmployeeImportanceDFS();
		int res = e.getImportance(employees, 1);
		System.out.println(res);

	}

}
