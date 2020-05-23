/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

//Time complexity: O(V+E) V is number of vertices and E is number of edges
//Space complexity: O(V+E)

/**
 * DFS
 * 1. Maintain the employees in map and check for its neighbours
 * 2. Search for given employee's subordinates and add up the importance.
 */


class EmployeeImportance {
    int totalImp;
    public int getImportance(List<Employee> employees, int id) {
        
        Map<Integer, Employee> map = new HashMap<>();
        
        for(Employee e : employees) {
            if(!map.containsKey(e.id)) {
                map.put(e.id, e);
            }
        }
        
        totalImp = 0;
        
        dfs(id, map);
        
        return totalImp;
        
    }
    
    private void dfs(int id, Map<Integer, Employee> map) {
        
        Employee curr = map.get(id);
        
        totalImp += curr.importance;
        
        for(int subId : curr.subordinates) {
            
            dfs(subId, map);
            
        }
        
    }
}