// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EmployeeImportance {
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
	        if(employees == null || employees.size() == 0) return 0;
	        HashMap<Integer, Employee> map = new HashMap<>();
	        for(Employee e: employees){
	            map.put(e.id, e);
	        }
	        Queue<Integer> q = new LinkedList<>();
	        q.add(id);
	        int result = 0;
	        while(!q.isEmpty()){
	            int eid = q.poll();
	            Employee e = map.get(eid);
	            result += e.importance;
	            for(int sub: e.subordinates){
	                q.add(sub);
	            }
	        }
	        return result;
	    }
	}
}
