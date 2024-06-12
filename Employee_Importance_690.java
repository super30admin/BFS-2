//Time Complexity : O(V+E)
//Space Complexity : O(max(V, E))
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

class Employee
{
	public int id;
	public int importance;
	public List<Employee>  subordinates;
}
class Employee_Importance_690 {
    public int getImportance(List<Employee> employees, int id) {
    	if(employees == null || employees.size() == 0)
    		return 0;
    	HashMap<Integer, Employee> map = new HashMap<>();
    	for(Employee e : employees)
    	{
    		map.put(e.id,  e);
    	}
    	Queue<Integer> q = new LinkedList<>();
    	q.add(id);
    	int result = 0;
    	while(!q.isEmpty())
    	{
    		int eid = q.poll();
    		Employee e = map.get(eid);
    		result += e.importance;
    		for(int sid : e.subordinates)
    		{
    			q.add(sid);
    		}
    	}
    	return result;
    }
}
