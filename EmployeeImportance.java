
// Time Complexity :O(n)
// Space Complexity :O(n+Max(subordinates))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

import java.util.*;
class Solution {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };
    public int getImportance(List<Employee> employees, int id) {
        
    HashMap<Integer, Employee> map= new HashMap<>();

    for(Employee e:employees)
    {
        map.put(e.id,e);
    }
    int sum =0;
    Queue<Integer> bfs = new LinkedList<>();
    bfs.add(id);
    while(!bfs.isEmpty())
    {
        Employee e = map.get(bfs.poll());
        sum+=e.importance;
        for(int x:e.subordinates)
        {
            bfs.add(x);
        }
    }
    return sum;
        
    }
}