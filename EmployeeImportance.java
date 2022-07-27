/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

//Time Complexity: O(n) number of subordinates;
//Space Complexity: O(n) n is number of employees in the list. //Adjacency list

class Solution {
    //adj list
    
    HashMap<Integer, Employee> map;
    int total; 
    
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;
        
        map = new HashMap<>();
        for(Employee e:employees){
            map.put(e.id, e);
        }
        
        dfs(id);
        
        return total;
    }
    
    
    private void dfs(int id){
        //base case
        if(map.get(id) == null) return;
        //logic

        Employee emp = map.get(id);
        total += emp.importance;
        for(int subs: emp.subordinates){
            dfs(subs);
        }
    }
}