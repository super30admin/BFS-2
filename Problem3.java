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
    HashMap<Integer,Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        
        for(Employee employee : employees){
            map.put(employee.id, employee);
        }
        dfs(id);
        return dfs(id);
        
    }
    
    public int dfs(int id){
        Employee employee=map.get(id);
        int val=employee.importance;
        List<Integer> subordinates=employee.subordinates;
        
        for(Integer sub : subordinates ){
                val+=dfs(sub);
        }
        return val;
    }
}