// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I had to code this in Java which I'm not comfortable with.  LeetCode doesn't have a
// JS Compiler for this problem

/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
// BFS
// class Solution {
//     public int getImportance(List<Employee> employees, int id) {
//         if (employees == null || employees.size() == 0) return 0;
//         int result = 0;
//         HashMap<Integer, Employee> map = new HashMap<>();
//         for (Employee e : employees) map.put(e.id, e);
//         Queue<Integer> q = new LinkedList<>();
//         q.add(id);
//         while(!q.isEmpty()) {
//             int eid = q.poll();
//             Employee e = map.get(eid);
//             result += e.importance;
//             List<Integer> subs = e.subordinates;
//             if (subs != null) {
//                 for (int subId : subs) q.add(subId);
//             }
//         }
//         return result;
//     }
// }

// DFS
class Solution {
    int result;
    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null | employees.size() == 0) return 0;
        result = 0;
        map = new HashMap();
        for (Employee e : employees) map.put(e.id, e);
        dfs(id);
        return result;
    }
    private void dfs(int id) {
        // Base Case
        
        // Logic
        Employee e = map.get(id);
        result += e.importance;
        List<Integer> subs = e.subordinates;
        for (int subId : subs) dfs(subId);
    }
}
