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
    int result=0;

    
    public int getImportance(List<Employee> employees, int id) {
     
        if(employees==null || employees.size()==0) return 0;
        
         HashMap<Integer,Employee>hashMap = new HashMap();
        for(int i=0;i<employees.size();i++){
            Employee emp = employees.get(i);
            hashMap.put(emp.id,emp);
        }
        empImp(hashMap,id);
        return result;
    }
    
    private void empImp(HashMap<Integer,Employee> map,int id){
        
        Employee emp = map.get(id);
        result+=emp.importance;
        for(int empIds:emp.subordinates){
            empImp(map,empIds);    
        }
        
        
    }
}
