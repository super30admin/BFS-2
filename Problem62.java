Time Complexity : O(N)
Space Complexity : O(N)

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

// BFS SOLUTION

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        if(employees == null || employees.size()<1) return 0;
        
        Map<Integer, Employee> hm = new HashMap<>();
        int result = 0;
        for(Employee e : employees){
            hm.put(e.id, e);
        }
        
        Queue<Integer> q = new LinkedList();
        q.offer(id);
        
        while(!q.isEmpty()){
            int eid = q.poll();
            Employee emp = hm.get(eid);
            result += emp.importance;
            if(emp.subordinates != null && emp.subordinates.size()>0){
                for(int e : emp.subordinates){
                    q.offer(e);
                }
            }
        }        
        return result;
    }
}


//DFS SOLUTION
class Solution {
    Map<Integer, Employee> hm;
    int result = 0;
    public int getImportance(List<Employee> employees, int id) {
        
        if(employees == null || employees.size()<1) return 0;
        
        hm = new HashMap<>();
        for(Employee e : employees){
            hm.put(e.id, e);
        }
     
        dfs(id);
        return result;
    }
    
    private void dfs(int empId){
            Employee emp = hm.get(empId);
            result += emp.importance;
            if(emp.subordinates != null && emp.subordinates.size()>0){
                for(int e : emp.subordinates){
                    dfs(e);
                }
            }
    }        
}