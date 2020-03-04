// =============================== DFS ======================================
/*
Time: O(N), space: O(N)
Approach:
========
1. Save id and employee details as key-value pairs in hashmap
2. Recursively DFS on employee and every subordinate of his  (employee.subordinates) to calculate total importance 

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
    Map<Integer, Employee> empMap;
    public int getImportance(List<Employee> employees, int id) {
        empMap = new HashMap<>();
        for(Employee employee: employees) {
            empMap.put(employee.id, employee);      // add id and employee details to hashmap
        }
        return dfs(id);
    }
    
    private int dfs(int id) {   
        Employee employee = empMap.get(id);         // Get employee details
        int result = employee.importance;           // calculate importance of employee
        
        for(int emp: employee.subordinates)         //calculate importance of each of his subordinates and their own subordinates
            result += dfs(emp);
        return result;
    }
}

// =============================== BFS ======================================

/*
Time: O(N) space:O(N) where N is number of employees
Algorithm:
=========
1. Add employee with required id to queue 
2. Poll employee ids from stack recursively, update total importance and push their own subordinates to stack until queue is empty
*/
class Solution {
    Map<Integer, Employee> empMap;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;
        empMap = new HashMap<>();       // map for O(1) access and search
        for(Employee employee: employees) {                 // add all ids, employee objects as key-value pairs
            empMap.put(employee.id, employee);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int result = 0;
        while(!q.isEmpty()) {                           // Iterate till  q is empty
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int eid = q.poll();                     // poll the queue and add employee's importance to result
                Employee emp = empMap.get(eid);
                result += emp.importance;                   
                List<Integer> subs = emp.subordinates;      
                for(int sub: subs)
                    q.add(sub);                         // add his/her subordinates' ids to the queue to process their own importance
            }
        }
        
        return result;
    }
}