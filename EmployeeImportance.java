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

// Time Complexity : O(N)
// Space Complexity : O(N)

// This solution uses DFS and a recursive stack call

class Solution {
    public int getImportance(List<Employee> employees, int id) {

        HashMap<Integer, Employee> map = new HashMap<>();

        // put the id in the hashmap
        for(Employee employee: employees){
            map.put(employee.id, employee);
        }


        return dfs(map, id);
    }

    private int dfs(HashMap<Integer, Employee> map, int id){
        Employee curr = map.get(id);

        int sum = curr.importance;

        for(Integer subordinate: curr.subordinates){
            sum += dfs(map, subordinate);
        }

        return sum;
    }

}