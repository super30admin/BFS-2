// Time Complexity : O(n + e) where n is the number of employees and e are the edges to subordinates
// Space Complexity :  O(n + e) where n is the number of employees and e are the edges to subordinates
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  Initially, I was using two hashmaps (one for subordinates and other for importance)
/* Your code here along with comments explaining your approach: We would store the hashmap of id and the employee object so that we have the 
access to all the employee information and we dont need to maintain addtional space. Object will give all the info. we use the stack for DFS, 
we start from the starting id, we move to its subordinates, extract their information such as id, and its importance value and their further
subordinates. We sum up the importance value and repeat the previous steps for the next employee who is a subordinate till we cover all the subordinates
of the starting node (id). 
*/

// DFS ITERATIVE
class Solution {
    HashMap<Integer, Employee> subMap;
    public int getImportance(List<Employee> employees, int id) {
        subMap = new HashMap<>();
        int sum = 0;
        if(employees ==  null || employees.size() == 0){return 0;}
        for(Employee e: employees){
            subMap.put(e.id, e);                                    // Map of employee ID and Employee object
        }
        Stack<Integer> stk = new Stack<>();
        stk.push(id);                                           // Start with the starting id
        while(!stk.isEmpty()){
            int i = stk.pop();
            Employee emp = subMap.get(i);                               // Extract the employeee information
            List<Integer> subord = emp.subordinates;                        // Get the subordinates of the extracted employee
            sum+=emp.importance;                                    // Add up the current id's importance value
            for(int j = 0; j< subord.size();j++){                   // Iterate over the subordinate list of the extracted employee
                stk.push(subord.get(j));
            }
        }
        return sum;
    }
}


// BFS 
class Solution {
    public int getImportance(List<Employee> employees, int id) {
         HashMap<Integer, Employee> subMap = new HashMap<>();
        int sum = 0;
        if(employees ==  null || employees.size() == 0){return 0;}                      // Base condition
        Queue<Integer> queue = new LinkedList<>();
        for(Employee e: employees){
            subMap.put(e.id, e);                                                // Employee Id with the employee object
        }
        queue.add(id);                                                      // Start with the given id
        while(!queue.isEmpty()){
            int identity = queue.poll();                                            // Fetch the employee and subordinates one by one
            Employee e = subMap.get(identity);
            List<Integer> sub = e.subordinates;                             // Extracting the subordinates of the fetched employee
            int imp = e.importance;
            sum+=imp;                                                   // Adding up the importance value
            for(int k = 0; k < sub.size(); k++){
            queue.add(sub.get(k));                                          // Adding the further subordinates in the queue
            }
        }
        return sum;
    }
}


// DFS RECURSIVE
class Solution {
    HashMap<Integer, Employee> subMap;
    int sum  = 0;
    public int getImportance(List<Employee> employees, int id) {
        subMap = new HashMap<>();
        if(employees ==  null || employees.size() == 0){return 0;}
        for(Employee e: employees){                                             // Map of Employee id and employee object
            subMap.put(e.id, e);
        }
        dfs(id);                                                                // Start with the given id
        return sum;
    }
    private void dfs(int id){
        Employee e = subMap.get(id);                                            // Extract the employee information
        List<Integer> sub = e.subordinates;                                     // Extract the subordinates of current employee
        int imp = e.importance;                                                 // Add up the importance value of the current employee
        sum+=imp;
        for(int i: sub){
            dfs(i);                                                         // Recurse over subordinates of the current employee
        }
    }
}