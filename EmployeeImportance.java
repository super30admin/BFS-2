/* https://leetcode.com/problems/employee-importance/
690. Employee Importance - EASY
*/

import java.util.*;
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

public class EmployeeImportance {
    /* Apprpach: the importance of every employee is the sume of importance of their subordinates.
    So, the importance is the sum of the importance of all employee subtrees originating at that employee id.
    Using BSF, start with the employee whose importance has to be calculated, in a queue.
    Visit its immediate children, and expnad by visiting children of all children, level by level,
    adding importance to the total importance.
    The final result is the total imporance.

    n - number of employees
    TC: O(n) => we need to visit all employees in the worst case in case of top manager
    SC: O(n) => we need to keep all subordinates in queue, if 1 manager and (n-1) subordinates.
    */
    public int getImportanceBFS(List<Employee> employees, int id) {
        int importance = 0;
        
        if (employees == null || employees.size() == 0) {
            return importance;
        }
        
        Map<Integer, Employee> m = new HashMap<>();        
        for (Employee e: employees) {
            m.put(e.id, e);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);      
                
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                int employeeId = q.remove();                
                Employee manager = m.get(employeeId);                
                importance += manager.importance;
                
                for (int sub: manager.subordinates) {
                    q.offer(sub);
                }                
            }
        }
        
        return importance;
    }
    
    /*
    The main idea is the same.
    In DFS, instead of adding to the total importance as we visit every level of subordinaes,
    we traverse from the top to the last level thru one chain. For an employee with no subordinates,
    the importance is their own imp.
    As we return from every child call, we add to the current id's importance, its child's importance

    TC: O(n) - visit all nodes once
    SC: O(n) - in case of skewed tree, with every employee having exactly one subordinate
    */
    public int getImportanceDFS(List<Employee> employees, int id) {
        int importance = 0;
        
        if (employees == null || employees.size() == 0) {
            return importance;
        }
        
        Map<Integer, Employee> m = new HashMap<>();        
        for (Employee e: employees) {
            m.put(e.id, e);
        }
        return helper(id, m);
    }
    
    private int helper(int id, Map<Integer, Employee> map) {
        Employee e = map.get(id);
        if (e.subordinates.size() == 0) {
            return e.importance;
        }
        
        int importance = e.importance;
        
        for (int subId: e.subordinates) {
            importance += helper(subId, map);
        }
        
        return importance;
    }
}