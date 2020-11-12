package Nov11;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
//Definition for Employee.
class Employee {
 public int id;
 public int importance;
 public List<Integer> subordinates;
};
*/

class EmployeeImportanceBFS {
 
 /*
  Time Complexity: O(V+E)
  Treating this problem as a graph problem, wherein each employee is a vertex(/node) and each subordinate relationship between employee vertices is an edge. 
 
  Space Complexity: O(V+E) 
  Hashmap contains V no.of entries where V is the number of employee vertices. 
  Queue contains E no.of elements where E is the number of subordinate relationship edges between the employees.
 
  Did this code successfully run on Leetcode : Yes
 
  Any problem you faced while coding this : No
     
  Approach: 
  BFS approach taken.
            
*/ 
   
 public int getImportance(List<Employee> employees, int id) {
     
     // edge conditions
     if (employees == null || employees.size() == 0) {
         return 0;
     }
     
     // Adding all employee objects with their id in hashmap for O(1) time complexity access
     Map<Integer, Employee> hm = new HashMap<>();    // O(V) time complexity
     for (Employee e: employees) {
         hm.put(e.id, e);
     }
     
     // Queue for BFS created and funct parameter employee id is added to the queue
     Queue<Integer> queue = new LinkedList<>();   // O(E) time complexity
     queue.add(id);
     
     int result = 0;
     
     // BFS traversal on the queue to add importance value of current employee node in the while loop to result variable and adding the subordinates of current employee node to the queue by traversing through the subordinates list for current employee object.
     while(!queue.isEmpty()) {
         int curEmpId = queue.poll();
         Employee curEmp = hm.get(curEmpId);
         result = result + curEmp.importance;
         List<Integer> curSubordinates = curEmp.subordinates;
         for (int subordinateId: curSubordinates) {
             queue.add(subordinateId);
         }
     }
     
     return result;
     
 }
}
