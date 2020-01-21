// Time Complexity :
//      n is the number of nodes in tree
//      h is the height of the tree
//      getImportance() - O(n)
//      
// Space Complexity :
//      getImportance() - O(h)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    HashMap<Integer, Employee> map = new HashMap<>();
    
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0)
            return 0;
        
        for(Employee emp : employees)
        {
            map.put(emp.id, emp);
        }
        
        return helper(id);
    }
    
    private int helper(int id)
    {
        Employee temp = map.get(id);
        
        int sum = temp.importance;
        
        if(temp.subordinates.size() == 0)
            return sum;
        
        for(int subs : temp.subordinates)
        {
            sum += helper(subs);
        }
        
        return sum;
    }
}