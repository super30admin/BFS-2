// There are two appraoches
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

// Your code here along with comments explaining your approach
// Approach 1: Using BFS
// Time Complexity : O(2n) = O(n)
//      n: number of emeployees
//    For creating HashMap and processing Queue
// Space Complexity : O(2n) = O(n)
//      n: number of emeployees
//    for HashMap and processing Queue
class Problem3S1 {

    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    /** find total importance */
    public int getImportance(List<Employee> employees, int id) {

        // intialize
        int result = 0;
        
        // edge case
        if(employees == null || employees.size() == 0)
            return result;
        
        // adjacency HashMap
        HashMap<Integer, Employee> myMap = new HashMap<>();
        
        // creating the map
        for(Employee tempEmployee:employees){
            
            int key = tempEmployee.id;
            if(!myMap.containsKey(key))
                myMap.put(key, tempEmployee);
            
        }
        
        // for processing in BFS manner
        Queue<Integer> myQueue = new LinkedList<>();
        
        // edge case
        if(!myMap.containsKey(id))
            return result;
        else
            myQueue.add(id);
        
        // BFS
        while(!myQueue.isEmpty()){
            
            // process in FIFO
            int currentId = myQueue.poll();
            if(myMap.containsKey(currentId)){
                // add importance
                result += myMap.get(currentId).importance;
                // add subordinates to queue
                myQueue.addAll(myMap.get(currentId).subordinates);
            }else
                break;
            
        }
        // return result
        return result;
    }
}

// Your code here along with comments explaining your approach
// Approach 2: Using DFS
// Time Complexity : O(n + h) = O(n)
//      n: number of emeployees
//      h: height of the subordinate tree
//    For creating HashMap 
// Space Complexity : O(n + h) = O(n+h)
//      n: number of emeployees
//      h: height of the subordinate tree
//    for HashMap and recursive stack
class Problem3S2 {

    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    // global result
    int result = 0;

    /** find total importance */
    public int getImportance(List<Employee> employees, int id) {
    
        // edge case
        if(employees == null || employees.size() == 0)
            return result;
        
        // create adjanecy HashMap
        HashMap<Integer, Employee> myMap = new HashMap<>();
        
        for(Employee tempEmployee:employees){
            
            int key = tempEmployee.id;
            if(!myMap.containsKey(key))
                myMap.put(key, tempEmployee);
            
        }

        // do dfs. Here myMap is just a reference
        depthFirstTraversal(id, myMap);

        // return result
        return result;
        
    }
    
    /** dfs traversal */
    private void depthFirstTraversal(int rootId, HashMap<Integer, Employee> myMap){
        // base case
        if(myMap.containsKey(rootId)){
            // add to result
            result += myMap.get(rootId).importance;
            // iterate all subordinates
            for(Integer subordinate:myMap.get(rootId).subordinates)
                depthFirstTraversal(subordinate, myMap);
        }
    }
}