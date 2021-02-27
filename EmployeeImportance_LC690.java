/* DFS
T: O()
S: O()

BFS
T: O()
S: 

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer, Employee> map;
    int result;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null) return -1;
        
        map = new HashMap<>();
        for(Employee e: employees) //O(V)
            map.put(e.id, e);
        
        dfs(id);
        return result;
    }
    
    private void dfs(int id){
        //base
        //no need here
        //logic
        Employee e = map.get(id); //O(V+E)
        result += e.importance;
        for(int i: e.subordinates){
            dfs(i);
        }
    }

    public int getImportanceBFS(List<Employee> employees, int id) {
        int result = 0;
        if(employees == null || employees.size() == 0) return result;
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees)
            map.put(e.id, e);
            
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        
        while(!q.isEmpty()){ //O(V+E)
            Employee e = map.get(q.poll());
            result += e.importance;
            for(int i: e.subordinates){
                q.add(i);
            }
        }
        
        return result;
    }
}