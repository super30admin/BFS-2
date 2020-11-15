// Time Complexity : O(V+E), where V is the number vertices(employees) and E is the number of edges(subordinates relation)
// Space Complexity :O(V+E), where V is the number vertices(storing all the ids with their Employee refrence in the HashMap) and 
        //E is the number of edges(storing the subordinates of each employee in the queue)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three Liner explanation of your code in plain english
//Store all the ids along with their Employee refernce in the HashMap and call DFS on the given id
// In the dfs function get the emplyee information for the passed id and aggregate the employee importance.
//Then keep calling DFS on all the subordinates of the id

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
    HashMap<Integer, Employee> hMap;
    int value;
    public int getImportance(List<Employee> employees, int id) {
        //edge case
        if(employees == null || employees.size() == 0) return 0;
        
        value =0;
        hMap = new HashMap<>();
        
        //put all the employess along with its id, importance and subordinates in the hashmap
        for(Employee e : employees){
            hMap.put(e.id, e);
        }
        //start dfs from the given id
        dfs(id);
        return value;
    }
    
    private void dfs(int id){
        //base (no base case)
        
        //logic
        //get the employee object from the HashMap
        Employee curr = hMap.get(id);
        //aggregate the current empoyee importance
        value += curr.importance;
        List<Integer> currSub = curr.subordinates;
        //call dfs on all the subordinates of the current employee
        for(int i=0; i<currSub.size(); i++){
            dfs(currSub.get(i));
        }
    }
}