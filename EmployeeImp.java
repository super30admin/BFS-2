// Time Complexity : 
//BFS : O(n), n is number of employees
//DFS : O(n)
// Space Complexity : 
//BFS : O(n), one manager has all other employees as subordinates
//DFS : O(n), each employee has one subordinate, so all the employees are added to the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//Solution BFS
//Create HashMap (adjanceny list) to keep track of employees
//employee id as key and id,importance, subordinates list as value
//add the given id to queue
//in while loop
//get front of queue (curr employee to process)
//get the curr employees details from the queue (Data Type : Employee)
//get the importance of the employee (currEmpDetails.importance) and add to the result
//get list of subordinates (for each loop) as currEmpDetails.subordinates, add to queue
//after while loop terminates, return result
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        //if employee input is empty, return 0
        if(employees == null) return 0;
        //initialize result as 0
        int result = 0;
        //create hasmap to store employee details (look up in O(1))
        HashMap<Integer, Employee> map = new HashMap<>();      
        //for each employee in the given input add to hashmap
        for(Employee e : employees) {
            //add emp id as key and the entire employee input for each employee as value
            map.put(e.id, e);
        }
        //Queue to add processed employees
        Queue<Integer> q = new LinkedList<>();
        //add the given input id into queue
        q.add(id);
        //do till queue is empty
        while(!q.isEmpty()) {
            //get front of queue (employee id)
            int currEmp = q.poll();
            //get its details from the map usinf (emp id)
            Employee currEmpDetails = map.get(currEmp);
            //get its importance and add to the result
            result += currEmpDetails.importance;
            //iterate through the employees subordinate list 
            //and add the subord ids to the queue
            for(int subordId : currEmpDetails.subordinates) {
                q.add(subordId);
            }
        }//when queue is empty all related subordinates have been processed
        //return the result
        return result;   
    }
}



///////////////////////


//Solution DFS
//Create HashMap (adjanceny list) to keep track of employees
//employee id as key and id,importance, subordinates list as values
//call dfs method on input id

class Solution {   
    //create hasmap to store employee details (look up in O(1))
    //create globally to access in dfs method
    HashMap<Integer, Employee> map;
    int result;
    
    public int getImportance(List<Employee> employees, int id) {
        //if employee input is empty, return 0
        if(employees == null) return 0;
        //initialize result = 0 at start
        result = 0;
        //create hasmap to store employee details (look up in O(1))
        map = new HashMap<>();      
        //for each employee in the given input employee data add to hashmap
        for(Employee e : employees) {
            //add emp id as key and the entire employee input for each employee as value
            map.put(e.id, e);
        }
        //call dfs method (id given as input (start dfs from this node)) recursively
        dfs(id);
        //return result
        return result;                
    }
    
    
    private void dfs(int id){
        //base condition
        //no base condition required as in logic only 
        //we check for subordinates in for loop
        // and no employee can have same manager
        
        //logic
        //get the currEmpDetails from map usind the id
        Employee currEmpDetails = map.get(id);
        //add the importance to result
        result += currEmpDetails.importance;
        //call dfs recursively on all its subordinates using subord id (int)
        for(int subordId : currEmpDetails.subordinates) {
            dfs(subordId);
        }     
    }    
}



