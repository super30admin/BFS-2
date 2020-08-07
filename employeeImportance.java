//Time Complexity : O(N)
//Space Complexity : O(N)



/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> empMap = new HashMap<>(); //smart decision here is to take complete employee object.
        if(employees == null || employees.size() == 0) return 0;
         for(Employee employee: employees) {                 
            empMap.put(employee.id, employee);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
         int result = 0;
        while(!q.isEmpty()) {                           
                int eid = q.poll();                     
                Employee emp = empMap.get(eid);
                result += emp.importance;                   
                List<Integer> subs = emp.subordinates;      
                for(int sub: subs)
                    q.add(sub);                         
            
        }
        
        return result;
    }
}