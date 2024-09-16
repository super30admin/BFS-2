// Time Complexity : O(n) for all the employees
// Space Complexity : O(n) for queue and map
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Store all the employee in hashmap with id as key and employee object as the value
// Add the given input id to queue and start iterating over
// Add the importance to a global variable to keep a count and check for the subordinates.
// If the subordinates are present add their id to queue and continue iteration to add their respective importances.

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
        int imp=0;
        HashMap<Integer, Employee> map = new HashMap<>();
        
        for(Employee emp : employees){
            map.put(emp.id,emp);
        }
        
        Queue<Integer> q =new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int size = q.size();
                int pop = q.poll();
                imp+=map.get(pop).importance;
                for(int sub : map.get(pop).subordinates){
                    q.add(sub);
                }
        }
        return imp;
    }
}