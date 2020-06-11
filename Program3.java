package LeetCode;

public class Program3 {
	
	/*
	// Employee info
	class Employee {
	    public int id;
	    public int importance;
	    public List<Integer> subordinates;
	    
	    Tc : O(n)
	    Sc : O9n)
	};
	*/
	class Solution {
	    public int getImportance(List<Employee> employees, int id) {
	        int res=0;
	        HashMap<Integer, Employee> map = new HashMap<>();
	        for(Employee emp : employees)
	            map.put(emp.id, emp);
	        
	        Queue<Employee> q = new LinkedList<>();
	        q.offer(map.get(id));
	        
	        while(!q.isEmpty()){
	            Employee temp = q.poll();
	            res+=temp.importance;
	            for(int subid : temp.subordinates)
	                q.add(map.get(subid));
	            
	        }
	        return res;
	    }
	}

}
