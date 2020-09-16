// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer, Employee> map = new HashMap();
    public int getImportance(List<Employee> employees, int id) {
        
        for(Employee e: employees){
            map.put(e.id,e);
        }
        
        return dfs(id);
    }
    
    public int dfs(int id){
        Employee e = map.get(id);
        int ans = e.importance;
        for(int sub: e.subordinates){
            ans += dfs(sub);
        }
        return ans;
    }
}
