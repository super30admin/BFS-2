// Time Complexity: O(n)
// Space Complexity: O(n) n = size of hashmap
// All test cases passed on leetcode

// BFS Approach

// We need to use HashMap because if we need importance if employee then we need to search for every element
// in the list employees which would be time expensive. So we use hashmap to store emp id and employee object as 
// searching in HashMap is O(1)
// Now we add the id to the queue and get its importance from hashmap, add it to result and add subordinates corresponding to the id to the queue.
// We repeat the same process until queue is empty and return the result.
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null) return 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e:employees) {
            map.put(e.id, e);
        }
        Queue<Integer> q = new LinkedList<>();
        int result = 0;
        q.add(id);
        while(!q.isEmpty()) {
            int eid = q.poll();
            Employee e = map.get(eid);
            result+=e.importance;
            for(int subId: e.subordinates) {
                q.add(subId);
            }
        }
        return result;
    }
}

// DFS Approach

// Time Complexity: O(n) for HashMap
// Space Complexity: O(h) h=height of stack

class Solution {
    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        for(Employee e: employees) map.put(e.id, e);
        return dfs(id);
    }
    
    private int dfs(int id) {
        Employee e = map.get(id);
        int res = e.importance;
        for(Integer subid: e.subordinates)
            res+=dfs(subid);
        return res;
    }
}