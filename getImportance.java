// Time Complexity :O(N)
// Space Complexity :Recursion stack + O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


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
        HashMap<Integer, Employee> map = new HashMap();
        
        for(Employee employee: employees){
            map.put(employee.id , employee);
        }
        
        return helper(map,id);
    }
    
    private int helper(HashMap<Integer, Employee> map , int rootId){
        Employee root = map.get(rootId);
        int total = root.importance;
        
        for(int subordinate : root.subordinates){
            total += helper(map,subordinate);
        }
        return total;
    }
}
