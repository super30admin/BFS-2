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
/*1. BFS approach
Time Complexity: O(n)
Space Complexity: O(n)
Successfully run on LeetCode: Yes
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0)
            return 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees)
            map.put(e.id, e);
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;
        queue.add(id);
        while(!queue.isEmpty()){
            int popped_id = queue.poll();
            Employee e = map.get(popped_id);
            result += e.importance;
            for(int sub_id: e.subordinates)
                queue.add(sub_id);
        }
        return result;
    }
}

/*2. DFS approach - Using Recursion
Time Complexity: O(n)
Space Complexity: O(n)
*/
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        //Base Case
        if(employees == null || employees.size() == 0)
            return 0;
		//logic
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees)
            map.put(e.id, e);
        return helper(map, id);
    }

    private int helper(HashMap<Integer, Employee> map, int id){
        Employee e = map.get(id);
        int result = e.importance;

        for(int sub_id: e.subordinates)
            result += helper(map, sub_id);

        return result;
    }
}