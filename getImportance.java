// Time Complexity : O(n) n is number of nodes
// Space Complexity :O(n) hashmap + O(s) number of subordinates to the lowest level of given employee (Recursive stack)
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
    int imp;
    Map<Integer,Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        if(employees.size()<=0) return 0;
        
        map = new HashMap<>();
        for(Employee emp : employees)
        {
            map.put(emp.id,emp);
        }
        
        dfs(id);
        return imp;
    }
    
    private void dfs(int id)
    {
        imp+=map.get(id).importance;
        for(int i=0;i<map.get(id).subordinates.size();i++)
        {
            dfs(map.get(id).subordinates.get(i));
        }
    }
    
    
}