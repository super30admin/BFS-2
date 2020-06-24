/**
 * Time complexity : O(N) (N for saving info in hashmap + N for the traversal) where N is number of nodes
 * Space Complexity : O(N) (Hashmap with employee it to the employee object)
 *
 * Just like trees, we'll traverse through employee subordinates in dfs or bfs manner to get the total importance.
 *
 */

import java.util.*;
public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {

        HashMap<Integer,Employee> map = new HashMap<>();
        for(Employee e : employees)
        {
            map.put(e.id, e);
        }

        int imp = 0;
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(id);
        while(!q.isEmpty())
        {
            Integer j = q.poll();
            imp = imp + map.get(j).importance;
            for(Integer i : map.get(j).subordinates)
            {
                q.add(i);
            }
        }
        return imp;
    }

    int imp = 0;
    HashMap<Integer,Employee> map;
    public int getImportanced(List<Employee> employees, int id) {
        map = new HashMap<Integer,Employee>();
        for(Employee e : employees)
        {
            map.put(e.id,e);
        }
        helper(id);
        return imp;

    }
    public void helper(int id)
    {
        imp =imp + map.get(id).importance;
        for(Integer i : map.get(id).subordinates )
        {
            helper(i);
        }
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};