// S30 Big N Problem #61 {Easy}
// 690. Employee Importance
// Time Complexity :O(n) where n is the number of employees
// Space Complexity :O(n)+O(n) where n is the number of employees (hashmap and queue)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None

// Your code here along with comments explaining your approach
// BFS Solution
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
        if(employees==null || employees.size()==0) return 0;
        int result=0;
        HashMap <Integer,Employee> map=new HashMap<>();
        for(Employee emp:employees){
            map.put(emp.id,emp);
        }
        Queue <Integer> q=new LinkedList<>();
        q.add(id);
        
        while(!q.isEmpty()){
            int eid=q.poll();
            Employee emp=map.get(eid);
            result+=emp.importance;
            for(int subid:emp.subordinates){
                q.add(subid);
            }  
        }
        return result;
    }
}