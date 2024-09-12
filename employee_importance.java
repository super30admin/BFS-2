/*
Time Complexity: O(N)
Space Complexity: O(N)
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer, Employee> map;
    int result;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        if(employees == null) return 0;
        for(Employee e: employees)
        {
            map.put(e.id, e);
        }
        
        dfs(id);
        return result;
    }
    
    private void dfs(Integer id)
    {
        Employee e = map.get(id);
        result = result + e.importance;
        for(int sub : e.subordinates)
        {
            dfs(sub);
        }
    }
}