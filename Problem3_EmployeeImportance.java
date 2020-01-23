/***************** Time Complexity: O(n) ***************** */
/***************** Space Complexity: O(n) ***************** */
//Depth First Search
/*
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
    
    public int getImportance(List<Employee> employees, int id) {
        //base case
        if(employees == null || employees.size() == 0)
            return 0;
        
        //create hashmap for id and employee class 
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees)
            map.put(e.id, e);
        
        return getTotalImp(map, id);
    }
    
    private int getTotalImp(HashMap<Integer, Employee> map, Integer id){
        //get if of the current employee
        Employee current_emp = map.get(id);
        //get the current importance value of the employee
        int total_imp = current_emp.importance;
        //for all subordinates present for the employee
        for(Integer subIds : current_emp.subordinates){
            //add all subordinates importance value
            total_imp += getTotalImp(map, subIds);
            
        }
        
        return total_imp;
    }
}

/************************************************************* */
/***************** Time Complexity: O(n) ***************** */
/***************** Space Complexity: O(n) ***************** */
// Breadth First Search
/*
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
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size()==0)
            return 0;
        //Creating HashMap of id and Emp object
        HashMap<Integer, Employee> map = new HashMap<>();
        //for each employee, create an entry
        for(Employee e : employees){
            map.put(e.id, e);
        }
        //queue is created for storing the subordinates of the employee
        Queue<Integer> q = new LinkedList<>();
        //add the first id in the queue
        q.add(id);
        int result = 0;
        while(!q.isEmpty()){
            //poll id and get its importance to add with result
            int eid = q.poll();
            Employee e = map.get(eid);
            result = result + e.importance;
            //get subordinates and add its importance
            for(int sId : e.subordinates){
                q.add(sId);
            }
        }
        
        return result;
        
    }
}