//Time complexity : O(n) (n for saving info in hashmap + n for the traversal)
//Space Complexity : O(n) Hashmap with employee it to the employee object
//Runs successfully on leetcode
//No problem


//Just like trees, we'll traverse through employee subordinates in dfs or bfs manner to get the total importance.


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS_2_Problem_3_empImp {
    public int getImportancebfs(List<Employee> employees, int id) {

        HashMap<Integer,Employee> hm = new HashMap<>();
        for(Employee e : employees)
        {
            hm.put(e.id, e);
        }

        int imp = 0;
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(id);
        while(!q.isEmpty())
        {
            Integer j = q.poll();
            imp = imp + hm.get(j).importance;
            for(Integer i : hm.get(j).subordinates)
            {
                q.add(i);
            }
        }
        return imp;
    }

    int imp = 0;
    HashMap<Integer,Employee> hm;
    public int getImportancedfs(List<Employee> employees, int id) {
        hm = new HashMap<Integer,Employee>();
        for(Employee e : employees)
        {
            hm.put(e.id,e);
        }
        helper(id);
        return imp;

    }
    public void helper(int id)
    {
        imp =imp + hm.get(id).importance;
        for(Integer i : hm.get(id).subordinates )
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