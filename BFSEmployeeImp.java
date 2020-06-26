// Time Complexity : O(n). n is the number of employees in the list
// Space Complexity : O(n).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
     
        if(employees==null || employees.size()==0) return 0;
        
        HashMap<Integer,Employee>hashMap = new HashMap();
        for(int i=0;i<employees.size();i++){
            Employee emp = employees.get(i);
            hashMap.put(emp.id,emp);
        }
        
        int totalImpValue=0;
        Queue<Integer>q = new LinkedList();
        q.add(id);
        
        while(!q.isEmpty()){
           int ids = q.poll();
            
            Employee emp = hashMap.get(ids);
            totalImpValue+=emp.importance;
            List<Integer> sub=emp.subordinates;
            int size = sub.size();
            
             for(int i=0;i<size;i++){
                  q.add(sub.get(i));
             }
        }
        
        
       
        return totalImpValue;
    }
}
