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

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) {
            return 0;
        }
        Map<Integer, Employee> map = new HashMap<>();

        for(Employee emp: employees) {
            map.put(emp.id, emp);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        int value = 0;
        while(!q.isEmpty()) {
            Employee emp = map.get(q.poll());
            value += emp.importance;
            List<Integer> list = emp.subordinates;
            for(int i: list) {
                q.offer(i);
            }
        }

        return value;
    }
}