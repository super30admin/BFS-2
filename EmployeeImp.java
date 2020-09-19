// Time Complexity : O(n) where n is the number of employees (if all emps are used up)
// Space Complexity : O(n) since we have to make a hm for all the emp ids
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/**
 * simple traversal(ordering doesnt matter so it can be done in both dfs/bfs)
 * create a hm with key as emp id and value as the employee object itself add
 * the main root to queue pop the queue and add its importance and its
 * subordinates
 */
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        int res = 0;

        // Creating (adjacency+values) list
        Map<Integer, Employee> hm = new HashMap<>();

        for (Employee emp : employees) {
            hm.put(emp.id, emp);
        }

        if (!hm.containsKey(id))
            return 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(id);

        while (!q.isEmpty()) {

            int boss = q.remove();
            Employee boss_emp = hm.get(boss);
            res += boss_emp.importance;

            for (int i : boss_emp.subordinates) {
                q.offer(i);
            }

        }
        return res;
    }
}