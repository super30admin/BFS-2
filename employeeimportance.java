// Time Complexity : O(2n) n to put in hashmap + n calls to dfs function
// Space Complexity : O(n+h)=O(n) all employees and their mapping in hashmap + h <- height of dfs
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Not much.


// Your code here along with comments explaining your approach


public class Solution {
    int result;
    public int getImportance(List<Employee> employees, int id) {
        
        HashMap<Integer,Employee> employee_mapper=new HashMap<>();
        result=0;
        
        for(Employee employee: employees)
          employee_mapper.put(employee.id, employee);
        
        get_importance(employee_mapper,id);
        
        return result;
    }
    
    public void get_importance(HashMap<Integer,Employee> employee_mapper,
                             int id)
    {
        result+=employee_mapper.get(id).importance;
        
        for(int i : employee_mapper.get(id).subordinates)
            get_importance(employee_mapper,i);
    }
}