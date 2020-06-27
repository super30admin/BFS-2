// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


/**
 *https://leetcode.com/problems/employee-importance/ 
 *
 *
 */
public class EmployeeImportance {
	public int getImportance(List<Employee> employees, int id) {

		if(employees == null || employees.size() == 0) return 0;

		int res = 0;
		Queue<Integer> q = new LinkedList<>();
		Map<Integer, Employee> idEmployeeMap = new HashMap<>();

		//maintain map of emp id and its subordinates
		for(Employee e: employees){
			idEmployeeMap.put(e.id, e);
		}

		//add emp id to queue for which we need importance score
		q.add(id);
		while(!q.isEmpty()) {
			int currEmp = q.poll();
			//get current emp childres from map
			Employee e = idEmployeeMap.get(currEmp);

			//add curr emp importance to result
			res+=e.importance;

			//add all its children to queue
			q.addAll(e.subordinates);
		}

		return res;
	}
}
