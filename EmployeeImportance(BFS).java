//Time Complexity : O(n), All the Employees
//Space Complexity : O(n),All the Employees 
//Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    HashMap<Integer, Employee> map;
    int totalImp;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null)return 0;
        map = new HashMap<>();
        totalImp = 0;
        Queue<Integer> q = new LinkedList<>();
        for(Employee e : employees){
            map.put(e.id,e);
        }
        q.add(id);
        while(!q.isEmpty()){
            int currEid = q.poll();
            Employee currEmp = map.get(currEid);
            totalImp += currEmp.importance;
            for(int subs : currEmp.subordinates ){
                q.add(subs);
            }
            
        }
        return totalImp;
    }
}