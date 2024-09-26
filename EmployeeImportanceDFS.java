package Nov11;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
//Definition for Employee.
class Employee {
 public int id;
 public int importance;
 public List<Integer> subordinates;
};
*/

class EmployeeImportanceDFS {
 
 /*
  Time Complexity: O(V+E)
  Treating this problem as a graph problem, wherein each employee is a vertex(/node) and each subordinate relationship between employee vertices is an edge. 
 
  Space Complexity: O(V+E) 
  Hashmap contains V no.of entries where V is the number of employee vertices. 
  Recursive stack contains E no.of elements where E is the number of subordinate relationship edges between the employees.
 
  Did this code successfully run on Leetcode : Yes
 
  Any problem you faced while coding this : No
     
  Approach: 
  DFS approach taken.
            
*/ 
   
 Map<Integer, Employee> hm;  
 int result;
 
 public int getImportance(List<Employee> employees, int id) {
     
     // edge conditions
     if (employees == null || employees.size() == 0) {
         return 0;
     }
     
     // Adding all employee objects with their id in hashmap for O(1) time complexity access
     hm = new HashMap<>(); // O(V) time complexity
     for (Employee e: employees) {
         hm.put(e.id, e);
     }
     
    dfs(id);
    return result;
     
 }
 
 // recursive helper function for DFS - logic similar to BFS except that here, we dont maintain a queue for subordinate employees but call the function recursively for each of the subordinate employees of current employee id.
 public void dfs(int id) {
     Employee curEmp = hm.get(id);
     result = result + curEmp.importance;
     List<Integer> curSubordinates = curEmp.subordinates;
     for (int subordinateId: curSubordinates) {
         dfs(subordinateId);
     }
 }
}
