// Time Complexity : O(n) --> where n is number of employees
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (690): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) return 0;
        
        int result = 0;
        HashMap<Integer, Employee> map = new HashMap<>();        
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        
        while (!q.isEmpty()) {
            int eid = q.poll();
            Employee e = map.get(eid);
            result += e.importance;
            for (int subId : e.subordinates) q.add(subId);
        }
        return result;
    }
}