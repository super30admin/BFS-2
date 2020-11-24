package S30.BFS_2;

/*DFS Solution
Time Complexity : O(N), N is number of employees
Space Complexity : O(N) - recursive stack space
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

/*BFS Solution
Time Complexity : O(N), N is number of employees
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EmployeeImportance {

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    //DFS Solution
    public int getImportanceDFS(List<Employee> employees, int id) {

        HashMap<Integer,Employee> empMap = new HashMap<>();
        for(Employee e : employees) empMap.put(e.id, e);
        Employee emp = empMap.get(id);
        return dfs(emp, empMap);

    }

    public int dfs(Employee employee, HashMap<Integer,Employee> employees){

        if(employee.subordinates.size() == 0) return employee.importance;

        int sum = employee.importance;
        for(int subordinate : employee.subordinates){

            Employee sub = employees.get(subordinate);
            sum = sum + dfs(sub, employees);
        }
        return sum;
    }

    //BFS Solution
    public int getImportanceBFS(List<Employee> employees, int id) {

        HashMap<Integer,Employee> empMap = new HashMap<>();
        for(Employee e : employees) empMap.put(e.id, e);
        Employee emp = empMap.get(id);
        int importance = 0;

        Queue<Employee> queue = new LinkedList<>();
        queue.offer(emp);

        while(!queue.isEmpty()){
            Employee curr = queue.poll();
            importance += curr.importance;
            for(int subid : curr.subordinates){
                Employee sub = empMap.get(subid);
                queue.offer(sub);
            }
        }

        return importance;
    }
}
