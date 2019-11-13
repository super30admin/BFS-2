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
/* 690. Employee Importance - BFS approach
Time Complexity: O(n)
Space Complexity: O(n)
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0)
            return 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees)
            map.put(e.id, e);
        Queue<Integer> q = new LinkedList<>();
        int result = 0;
        q.add(id);
        while(!q.isEmpty()){
            int popped_id = q.poll();
            Employee e = map.get(popped_id);
            result += e.importance;
            for(int sub_id: e.subordinates)
                q.add(sub_id);
        }
        return result;
    }
}

/* 690. Employee Importance - DFS approach - Recursion
Time Complexity: O(n)
Space Complexity: O(n) -- HashMap plus recursive stack - Asymptotic Space Complexity
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        //Edge Case
        if(employees == null || employees.size() == 0)
            return 0;

        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees)
            map.put(e.id, e);
        return helper(map, id);
    }

    private int helper(HashMap<Integer, Employee> map, int id){
        Employee e = map.get(id);
        int result = e.importance;

        //now loop over the subordinates of this employee
        for(int sub_id: e.subordinates)
            result += helper(map, sub_id);

        return result;
    }
}
