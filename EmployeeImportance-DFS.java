/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/

class Solution {
    int result;
    HashMap<Integer,Employee> map = new HashMap<>();
    
    public int getImportance(List<Employee> employees, int id) {
        
        if (employees == null || employees.size() == 0){
            return 0;
        }
        
        for (Employee e : employees){
            map.put(e.id,e);
        }
        
        dfs(id);
        
        return result;
        
    }
    
    private void dfs(int id){
        Employee e = map.get(id);
        
        result = result + e.importance;
        
        for (int subordinate : e.subordinates){
            dfs(subordinate);
        }
    }
}