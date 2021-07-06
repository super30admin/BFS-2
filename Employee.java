//Time: O(N), 
//space: O(N)

// Employee info
//class Employee {
      // It's the unique id of each node;
      // unique id of this employee
    //public int id;
      // the importance value of this employee
    //public int importance;
      // the id of direct subordinates
    //public List<Integer> subordinates;
//};

//<----DFS---->
class Solution {
    Map<Integer, Employee> empMap;
    public int getImportance(List<Employee> employees, int id) {
        empMap = new HashMap<>();
        for(Employee employee: employees) {
            empMap.put(employee.id, employee);      
        }
        return dfs(id);
    }
    
    private int dfs(int id) {   
        Employee employee = empMap.get(id);         
        int result = employee.importance;           
        
        for(int emp: employee.subordinates)         
            result += dfs(emp);
        return result;
    }
}

<-----BFS---->
class Solution {
    Map<Integer, Employee> empMap;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;
        empMap = new HashMap<>();       
        for(Employee employee: employees) {                 
            empMap.put(employee.id, employee);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int result = 0;
        while(!q.isEmpty()) {                           
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int eid = q.poll();                     
                Employee emp = empMap.get(eid);
                result += emp.importance;                   
                List<Integer> subs = emp.subordinates;      
                for(int sub: subs)
                    q.add(sub);                         
            }
        }
        
        return result;
    }
}