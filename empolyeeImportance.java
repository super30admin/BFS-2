// Time Complexity : o(V + E)
// Space Complexity : o(V + E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 690
//Approach : BFS



/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/


class Solution {
    public int getImportance(List<Employee> employees, int id) {
        //base
        if(employees == null || employees.size() == 0) return 0;
    
        HashMap<Integer, Employee> employee = new HashMap<>();
        for(Employee e: employees ){
            employee.put(e.id ,e);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int result = 0;
        while(!q.isEmpty()){
             int eid = q.poll();
             Employee e = employee.get(eid);
             result += e.importance;
             for(int sid : e.subordinates){
                 q.add(sid);
             }    
        }
    return result;
        
    }
}


// Time Complexity : o(V + E)
// Space Complexity : o(V + E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 994
//Approach : DFS

class Solution {
    int result;
    HashMap<Integer, Employee> employee = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        //base
        if(employees == null || employees.size() == 0) return 0;     
        for(Employee e: employees ){
            employee.put(e.id ,e);
        }
        dfs(id);
  return result;        
    }
    
            private void dfs(int id){
            
            //base
            //No base required
            //logic
            Employee e = employee.get(id);
            result+= e.importance;
            for(int sid: e.subordinates){
                dfs(sid);
            }   
        }
}