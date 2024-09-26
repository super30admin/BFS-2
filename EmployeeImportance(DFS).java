//Time Complexity : O(n), All the Employees
//Space Complexity : O(n),All the Employees 
//Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer, Employee> map;
    int totalImp;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null)return 0;
        map = new HashMap<>();
        totalImp = 0;
        for(Employee e : employees){
            map.put(e.id,e);
        }
        
        dfs(id);      
        return totalImp;
    }
    private void dfs(int id){
        
        Employee emp = map.get(id);
        totalImp += emp.importance;
        for(int subs : emp.subordinates){
            dfs(subs);
        }
        
    }
}