// S30 Big N Problem #61 {Easy}
// 690. Employee Importance
// Time Complexity :O(n) where n is the number of employees
// Space Complexity :O(n)+O(h){recursive stack} where n is the number of employees (hashmap) and h is the height of the tree 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None

// Your code here along with comments explaining your approach
// DFS Solution
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
    int result=0;
    public int getImportance(List<Employee> employees, int id) {
        if(employees==null || employees.size()==0) return result;
        HashMap<Integer,Employee> map=new HashMap<>();
        for(Employee emp:employees){
            map.put(emp.id,emp);
        }
        dfs(map,id);
        return result;
    }
    
    private void dfs(HashMap <Integer,Employee> map,int id){
        Employee emp=map.get(id);
        result+=emp.importance;
        for(int subid:emp.subordinates){
            dfs(map,subid);   
        }
    }
}