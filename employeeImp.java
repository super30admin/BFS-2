// TC: O(N) since we are checking every employee who is an direct employee.
// SC: O(N) it is size of the queue where we are storing employees into queue.

// We are traversing through the list of employee records and adding the employee records with key as employee id and employee data as value. 
// Since we are using bfs technique, we put the employee of the id which we need to return the importance of itself and its subordinates onto the queue.
// We traverse the employee record using the employee information mapped to the id in Hashmap. once we have employee, we add its importance and store its 
// subordinates details onto queue. In this way,we add the employee importance. once we have received the employee importance, we return the total of all direct employees.


import java.util.*;

public class employeeImp {

	public int employeeImportance(List<Employee> employees, int id) {
		
		HashMap<Integer, Employee> map = new HashMap();
		int total = 0;
		for(Employee e: employees) {
			map.put(e.id, e);
		}

		Queue<Employee> queue = new LinkedList();
		
		queue.offer(map.get(id));
		
		while(!queue.isEmpty()) {
			Employee e = queue.poll();
			
			total += e.importance;
			for(int subordinate: e.subordinates) {
				queue.offer(map.get(subordinate));
			}
		}
		return total;
	}
}
