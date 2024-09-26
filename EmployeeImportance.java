// Time Complexity : O(N) all the employees in the list
// Space Complexity : O(H) where H is the height of the tree, employees form a tree like structure which
// we are traversing using dfs. DFS uses recursion stack as additional space.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// We have calculate the total importance for a particular employee. We can add importance of current employee
// and recursively call dfs on that employee's subordinate and add its importance to the total importance. And keep doing the
// same until there is no more subordinate employee left.

import java.util.List;

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {

        Employee emp = null;
        for (Employee em : employees) {
            if (id == em.id) {
                emp = em;
            }
        }

        if (emp == null) return 0;

        List<Integer> subs = emp.subordinates;

        int totalImp = emp.importance;

        for (Integer sub : subs) {
            totalImp += getImportance(employees, sub);
        }

        return totalImp;
    }
}

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
