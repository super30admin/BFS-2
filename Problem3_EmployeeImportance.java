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