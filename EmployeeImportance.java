//Time Complexity: O(n) total no of employees in the worst case
//Space Complexity: O(n) - stack calls
//LeetCode: Yes

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
    Map<Integer, Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        //put the id in a hashmap 
        for(Employee e: employees){
        map.put(e.id, e);
        }
        return dfs(id);
        //traverse the sub nodes
    }
    public int dfs(int id){
        Employee emp = map.get(id);
        int importance = emp.importance;
        for(Integer i: emp.subordinates){
            importance += dfs(i);
        }
        return importance;
    }
}
