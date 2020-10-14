// Time Complexity : O(n), worst case add all employees to queue
// Space Complexity : O(n), for hashmap to store all employee information, queue size
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 
//initially just summed the importance of subordinates 

// Your code here along with comments explaining your approach
// importance of employee is sum of importance of subordinates
// but subordinates can have subordinates
// so a standard bfs, add employee to queue, poll() and add all subordinates to queue, do until queue is empty

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees==null || employees.size()==0) return 0;
        
        HashMap<Integer, Employee> employeeInfo = new HashMap<Integer, Employee>();
        
        for(Employee e : employees){
            employeeInfo.put(e.id, e);
        }
        
        Queue<Employee> queue = new LinkedList<Employee>();
        queue.add(employeeInfo.get(id));
        int totalImportance = 0;
        
        while(!queue.isEmpty()){
            Employee e = queue.poll();
            totalImportance += e.importance;
            
            for(int s : e.subordinates){
                queue.add(employeeInfo.get(s));
            }
        }
        
        return totalImportance;
    }
}