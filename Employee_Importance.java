import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Employee_Importance {
	//Approach: BFS
	//1. Here we will have a queue and put the id into the queue. So to process the subordinates, while processing the id, we will get the importnce value of that node
	// and we will start adding the subordinate nodes into the queue. So we can process them in the same manner and keep adding the importance value.
	public int getImportance(List<Employee> employees, int id) {
        int result = 0;
        if(employees == null )
            return 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee object: employees)
            map.put(object.id, object);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        while(!queue.isEmpty())
        {
            int empId = queue.poll();
            result += map.get(empId).importance;
            List<Integer> subId = map.get(empId).subordinates;
            if(subId == null)
                return result;
            for(int subordinates: subId)
                queue.add(subordinates);
        }
        return result;
    }
}
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
//Time Complexity : O(n) 
//Space Complexity : O(n) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :