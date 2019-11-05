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


/*Algorithm:
    - Add the employees into a HashMap and Map it with their respective id.
    - From the HashMap get the employee of whose id is passed while calling the function getImportance.
    - While queue is not empty poll the element from the queue, Add its importance do a BFS to add the employee's subordinates
    
*/    
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        int importance = 0;
        
        
      Map<Integer, Employee> empHash = new HashMap<>();
     for(Employee e: employees){
         empHash.put(e.id, e);
     }   
        Queue<Employee> q = new LinkedList<>();
        q.add(empHash.get(id));
        while(!q.isEmpty()){
            Employee emp = q.poll();
            importance+=emp.importance;
            for(int empsub: emp.subordinates){
                q.add(empHash.get(empsub));
            }
            
        }
        
        return importance;
        
    }
}