/*
Author: Akhilesh Borgaonkar
Problem: LC 690. Employee Importance (BFS-2)
Approach: Using recursive DFS approach here.  
Time Complexity: O(n) where n is number of employees in the input list.
Space complexity: O(n) where n is number of employees in the input list.
LC verified.
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        //base case
        if(employees == null || employees.size() == 0)
            return 0;
        //storing all the employee objects in hashmap with id as key for faster retrieval
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees)
            map.put(e.id, e);
        
        return getImp(map, id);
    }
    
    private int getImp(HashMap<Integer, Employee> map, Integer id){
        Employee curr_emp = map.get(id);
        int total_imp = curr_emp.importance;
        //performing depth first search on the subordinate employees to calculate total importance of superior employee
        for(Integer subIds : curr_emp.subordinates){
            total_imp += getImp(map, subIds);
        }
        
        return total_imp;
    }
}