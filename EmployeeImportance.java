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

public class EmployeeImportance {

	private int getImportance(List<Employee> employees, int id) {
		
		if(employees == null || employees.size()==0)
			return 0;
		
		int result = 0;
		HashMap<Integer, Employee> map = new HashMap<>();
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(id);
		for(Employee empl : employees) {
			map.put(empl.id, empl);
		}
		
		while(!q.isEmpty()) {
			int eid = q.poll();
			Employee emp = map.get(eid);
			result += emp.importance;
			List<Integer> subs = emp.subordinates;
			
			if(subs != null) {
				for(int sub_Id: subs) {
					q.add(sub_Id);
				}
			}
			
		}
		
		

		return result;
	}

	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.id = 1;
		e1.importance = 5;
		e1.subordinates = new ArrayList<>(Arrays.asList(2, 3));
		
		
		Employee e2 = new Employee();
		e2.id = 2;
		e2.importance = 3;
		e2.subordinates = new ArrayList<>();
		
		Employee e3 = new Employee();
		e3.id = 3;
		e3.importance = 3;
		e3.subordinates = new ArrayList<>();
		
		List<Employee> employees = new ArrayList<>();
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
				
		EmployeeImportance e = new EmployeeImportance();
		int res = e.getImportance(employees, 1);
		System.out.println(res);

	}

}
