import java.util.*;
// Definition for Employee.
class Employee {
	public int id;
	public int importance;
	public List<Integer> subordinates;
};

/***********************************************Brute Force********************************************/
//Time Complexity :O(n^2), where n is the number of total employees.
//Space Complexity : O(n), where n is the number of total employees.
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
	public int getImportance(List<Employee> employees, int id) {
		int result = 0;
		for(Employee e: employees){
			if(e.id == id){
				result = e.importance;
				if(!e.subordinates.isEmpty()){
					for(int sub : e.subordinates){
						result += getImportance(employees, sub);
					}
				}
				return result;
			}
		}
		return result;
	}
}

/***********************************************BFS***********************************************/
//Time Complexity :O(n), where n is the number of total employees.
//Space Complexity : O(n), where n is the number of total employees.
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/*Using BFS, where all subsequent employees for the given employee will be processed to add their importance.*/

class SolutionBFS {
	public int getImportance(List<Employee> employees, int id) {
		HashMap<Integer, Employee> map = new HashMap<>();

		for(Employee e : employees) // insert emp id and their object in map so that we dont have to traverse the employee list again and again
			map.put(e.id, e);

		Queue<Integer> q = new LinkedList<>();
		q.add(id);	// adding id for which importance has to be found

		int result = 0;
		while(!q.isEmpty()){
			int curr = q.poll();	//get latest employee out of queue

			Employee e = map.get(curr);	// get the employee details
			result += e.importance;	// add importance to the total result

			for(int subId : e.subordinates)	// iterate on the subordinates of the curr employee and add them to queue
				q.add(subId);
		}
		return result;
	}
}

/***********************************************DFS***********************************************/
//Time Complexity :O(n), where n is the number of total employees.
//Space Complexity : O(n), where n is the number of total employees.
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/* Using DFS, where all subsequent employees for the given employee will be processed to add their importance. */

class SolutionDFS {
	HashMap<Integer, Employee> map;
	int result;
	public int getImportance(List<Employee> employees, int id) {
		map = new HashMap<>();
		result = 0;
		for(Employee e : employees)	// insert emp id and their object in map so that we dont have to traverse the employee list again and again
			map.put(e.id, e);

		dfs(id);	// calling dfs on id of employee for which importance has to be found

		return result;
	}

	private void dfs(int id){
		// no base case as for loop runs till subordinates are present

		//logic
		Employee e = map.get(id);	//get the employee details
		result+= e.importance;	// adding its importance to result

		for(int subId: e.subordinates)	// traverse the subordinates and call dfs on them
			dfs(subId);
	}
}