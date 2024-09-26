// Time Complexity : O(n) --> where n is number of employees
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (690): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    int result;
    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) return 0;
        
        result = 0;
        map = new HashMap<>();        
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        
        dfs(id);
        return result;
    }
    
    private void dfs(int id) {
        // logic
        Employee e = map.get(id);
        result += e.importance;
        for (int i : e.subordinates) dfs(i);
    }
}