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

	
 * Time Complexity : O(n)
 * Space Complexity : O(n) where n is number of employees
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        if (employees.size() == 0){
            return 0;
        }
        
        HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
        for(Employee emp : employees){
            map.put(emp.id, emp);
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(id);
        int result = 0;
        
        while(!queue.isEmpty()){
            int empId = queue.poll();
            result += map.get(empId).importance;
            
            for(Integer em : map.get(empId).subordinates){
                queue.add(em);
            }
        }
        
        return result;
    }
}