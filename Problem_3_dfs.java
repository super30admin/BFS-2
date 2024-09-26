// Time complexity - O(n)
// Space complexity - O(n) {map - O(n) and recursive stack - O(h)}

// DFS

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer,Employee> map;
    int result;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        if(employees == null){
            return 0;
        }
        for(Employee e : employees){
            map.put(e.id,e);
        }
        dfs(id);
        return result;
    }
    
    private void dfs(int eid){
        // base
        
        // logic
        Employee e = map.get(eid);
        result += e.importance;
        for(int a : e.subordinates){
            dfs(a);
        }
    }
}
