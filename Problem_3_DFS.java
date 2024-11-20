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

 * Time Complexity : O(n)
 * Space Complexity : O(n) where n is number of employees
*/
class Solution {
    int result = 0;
    public int getImportance(List<Employee> employees, int id) {
        
        if (employees.size() == 0){
            return 0;
        }
        
        HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
        for(Employee emp : employees){
            map.put(emp.id, emp);
        }
        
        dfs(map, id);
        return result;
    }
    
    private void dfs(Map<Integer, Employee> map, int id){
        
        result = result + map.get(id).importance;
        
        for(Integer i : map.get(id).subordinates){
            dfs(map, i);
        }
    }
}