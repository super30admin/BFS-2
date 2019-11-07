/**
Daily Problem #61
Time Complexity : O(N^2)
Space Complexity : O(N) 
Did this code successfully run on Leetcode : Yes 
Any problem you faced while coding this: 
 */

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees.size() == 0) return 0;
        
        int importance = 0;
        Employee emp = getEmployee(employees, id);
        
        Queue<Employee> q = new LinkedList<>();
        Map<Integer, Boolean> visited = new HashMap();

        q.add(emp);
        visited.put(emp.id, true);
        
        // Level order traversal through list of subordinates for employee w/ given id
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i< size; i++){
                Employee current = q.poll();
                importance += current.importance;
        
                for(Integer subordinateId : current.subordinates){
                    // Check whether subordinate has been seen already
                    if(!visited.containsKey(subordinateId)){
                        Employee subordinate = getEmployee(employees, subordinateId);
                        q.add(subordinate);
                        visited.put(subordinateId, true);
                    }
                }
            }
        }
        
        return importance;
    }
    
    public Employee getEmployee(List<Employee> employees, int id){
        for(Employee employee : employees){
            if(employee.id == id) return employee;
        }
        return null;
    }
}