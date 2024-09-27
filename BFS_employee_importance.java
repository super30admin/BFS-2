// Time Complexity : O(V+E), where V is the number of vertices(employees) and E is the number of edges (subordiantes relation)
// Space Complexity :O(V+E), where V is the number of vertices(stored in HashMap along with the refernece as value) and 
                        //E is the number of edges (stored in the queue, (all subordinates of an employee))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three Liner explanation of your code in plain english
//1. Create a HashMap and store all the employee ids along with their reference as value in the hashMap.
//2. Create a queue and add the given id to start the BFS. Removing each employee from the queue, aggregate its importance and add
        // all its subordinates in the queue to be processed.
//3. Repeat this till the queue is empty and in the end return the final aggregated importance

// Your code here along with comments explaining your approach

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
        //edge case
        if(employees == null || employees.size() == 0) return 0;
        
        int value =0;
        HashMap<Integer, Employee> hMap = new HashMap<>();
        
        //put all the employess along with its id, importance and subordinates in the hashmap
        for(Employee e : employees){
            hMap.put(e.id, e);
        }
        
        //Create a queue to maintain all the subordinate  if an employee to be processed
        Queue<Integer> q = new LinkedList<>();
        //put the given id in the queue start the DFS
        q.add(id);
        
        while(!q.isEmpty()){
            int curr = q.poll();
            Employee currEmp = hMap.get(curr);
            //add the importance to the total importance
            value += currEmp.importance;
            
            //add all the subordinates of the curr employee in the queue to be processed
            List<Integer> currSub = currEmp.subordinates;
            for(int i=0; i<currSub.size(); i++){
                q.add(currSub.get(i));
            }
        }
        return value;
    }
}