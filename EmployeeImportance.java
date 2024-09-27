// Time Complexity : O(N) - As we iterate through the whole list
// Space Complexity : O(N) - AS We use a HashMap to store employeeID as key and Employee as value
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
/*Here we use a HashMap to store employee information.we use a recursive function to calculate the total importance */
class Solution {
    HashMap<Integer,Employee> map = new HashMap<>();
    public int dfs(int id){
        Employee e = map.get(id);
        int ans = e.importance;
        for(int sub : e.subordinates){
            ans = ans + dfs(sub);
        }
        return ans;
        
    }
    public int getImportance(List<Employee> employees, int id) {
        int sum = 0;
        
        for(Employee e : employees){
            map.put(e.id,e);
        }
        return dfs(id);
    }
}
}
// Your code here along with comments explaining your approach