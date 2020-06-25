/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
 // Time Complexity : O(n) n:no. of employees; we are visiting all employees once
 // Space Complexity : O(n) HashMap contains all employees records
 // Did this code successfully run on Leetcode : Yes
 // Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. Take HashMap to store all records.
 2. Use bfs method through Queue and keep computing the root and adding the   children.
 */
    
    
    public int getImportance(List<Employee> employees, int id) {
        
        if(employees == null) return 0;
        int result = 0;
        HashMap<Integer,Employee> hm = new HashMap<>();
        for(Employee e : employees){
            hm.put(e.id,e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int eid = q.poll();
            Employee emp = hm.get(eid);
            result = result + emp.importance;
            for(Integer subOrdinate : emp.subordinates){
                q.add(subOrdinate);
            }
        }
        return result;
    }
    
}








/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
 // Time Complexity : O(n) n:no. of employees; we are visiting all employees once
 // Space Complexity : O(n) HashMap contains all employees records
 // Did this code successfully run on Leetcode : Yes
 // Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. Take HashMap to store all records.
 2. Use dfs method through recursion and traverse till leaf nodes and then computing the root of popped record
 */
    HashMap<Integer,Employee> hm;
    int result;
    
    public int getImportance(List<Employee> employees, int id) {
        
        if(employees == null) return 0;
        
        hm = new HashMap<>();
        for(Employee e : employees){
            hm.put(e.id,e);
        }
        dfs(id);
        return result;
    }
    
    private void dfs(int id){
        Employee emp = hm.get(id);
        result = result + emp.importance;
        for(Integer subOrdinate : emp.subordinates){
            dfs(subOrdinate);
        }
    }
    
}