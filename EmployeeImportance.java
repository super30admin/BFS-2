

import java.util.*;

// Time Complexity : O(N) for DFS and BFS
// Space Complexity : O(1) for DFS,O(N) for BFS
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
public class EmployeeImportance {
    int totalImportance = 0;
    public int getImportance(List<Employee> employees, int id) {
        int total = 0;
        HashMap<Integer,Employee> map = new HashMap<>();
        Queue<Integer> queue =new LinkedList<>();
        for(Employee e: employees){
            map.put(e.id,e);
        }
        queue.add(id);
        while(!queue.isEmpty()){
            int eid = queue.poll();
            Employee e  = map.get(eid);
            total += e.importance;
            for(int sub  : e.subordinates){
                queue.add(sub);
            }
        }
        dfs(map,id);
        return totalImportance;
    }

    public void dfs(HashMap<Integer,Employee> map,int id){
        Employee e = map.get(id);
        totalImportance += e.importance;
        for(int subId : e.subordinates){
            dfs(map,subId); 
        }
    }
}