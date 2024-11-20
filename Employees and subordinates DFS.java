// Time complexity 0(n)
// space complexity 0(n)
// Code successfully executed in leetcode.
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
        //base case
        if(employees == null || employees.size() == 0) return 0;
        HashMap<Integer,Employee> map = new HashMap<>();
         for (Employee e : employees){
             map.put(e.id,e);
         }
         // Here whole list is not necessary because making a hashmap of it.
         dfs(map,id);
         return result;
    }
    private void dfs(HashMap<Integer,Employee> map, int id){
        Employee e = map.get(id);
        result += e.importance;
        for(int subId : e.subordinates){
                 dfs(map,subId);                 
    }
    }
}