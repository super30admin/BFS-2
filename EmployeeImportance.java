// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashMap;
import java.util.List;

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
    // use DFS
    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0){
            return 0;
        }
        map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        return dfs(id);
    }

    public int dfs(int id){
        Employee employee = map.get(id);
        int ans = employee.importance;

        for(Integer subid: employee.subordinates){
            ans += dfs(subid);
        }
        return ans;
    }
}
