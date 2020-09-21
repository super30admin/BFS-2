    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/employee-importance/
    Time Complexity for operators : o(n) .. hashmap interation .. n = number of employees
    Extra Space Complexity for operators : o(n) ... Queue.
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach 

        # Optimized approach: 
                              
              # - Approach
                    A. Add all the employees with its submordinates which is list into Hashamp
                       It will retrieve the data in O(1) time.
                    B. Add the input id into the queue and now we will do BFS on that element.
                    C. Once we have data in queue we will process it and get the list from hashMap.
                    D. We will add the importance of those employee for final sum.
                    E. in the end return final sum.
       */

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class employeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        
        HashMap<Integer, Employee> hm = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        
        // first add all data into the HashMap
        
        for(Employee emp : employees)
            hm.put(emp.id, emp);
         
        int finalCount = 0;
        // then add first or root or given element to the queue.
        queue.add(id);
        
        // process all its subordinates
        
        while(!queue.isEmpty()){
            int front = queue.poll();
            finalCount += hm.get(front).importance;
            for(int sub : hm.get(front).subordinates){
                queue.add(sub);
            }
        }
        
        return finalCount;
    }
}