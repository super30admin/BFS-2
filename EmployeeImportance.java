// Time Complexity :O(N) N = no of employees
// Space Complexity :O(N) N = no of employees
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//1. Store the employee details and traverse though the details using the id and retrieve the importance
import java.util.*;
public class EmployeeImportance {
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
    
    public int getImportance(List<Employee> employees, int id) {
        int imp = 0;

        HashMap<Integer, Employee> emp = new HashMap<>();
        for (Employee e : employees) {
            emp.put(e.id, e);
        }

        Queue<Integer> q = new LinkedList<>();

        q.add(id);

        while (!q.isEmpty()) {
            int temp = q.remove();
            Employee e = emp.get(temp);
            imp += e.importance;
            for (int sub : e.subordinates) {
                q.add(sub);
            }
        }
        return imp;
    }
   
}
