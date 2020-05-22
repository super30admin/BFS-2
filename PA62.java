//Leetcode 690. Employee Importance
//Time Complexity : O(n) , n is number of employees
//Space Complexity: O(n) , For hashmap of size equal to no. of employees
class Solution {
    int imp=0;
    HashMap<Integer, Employee> hsub;
    public int getImportance(List<Employee> employees, int id) {
        if(employees ==null || employees.size()==0) return 0;
        hsub= new HashMap<>();
        for(Employee e: employees ){
            hsub.put(e.id,e);           
        }        
        dfs(id);
        return imp;
    }
    private void dfs(int id){
        Employee e= hsub.get(id);
        imp=imp+e.importance;    
        for(Integer i :e.subordinates){
            dfs(i);
        }
        return;
        
    }
}