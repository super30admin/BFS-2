// Time Complexity : O(n) where n is the size of the list
// Space Complexity : O(n) where n is the size of the list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// using HashMap for O(1) lookup for importance using employee ids

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

class employeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        if (employees.size() == 0) return 0;
        int ans = 0;
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        q.add(id);
        while (!q.isEmpty()) {
            int empId = q.poll();
            Employee emp = map.get(empId);
            ans += emp.importance;
            for (int subId : emp.subordinates) {
                q.add(subId);
            }
        }
        return ans;
    }
}