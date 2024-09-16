// Time Complexity: O(n)
// Space Complexity: O(n)
// Solved on leetcode: For some reason I am getting parseException error on leetcode. But, I don't see any issue with the code.

class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        if (employees == null || employees.size() == 0) return 0;
        
        HashMap<Integer,Employee> map = new HashMap<>();
        for (Employee e: employees) {
            map.put(e.id,e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int result = 0;
        
        while (!q.isEmpty()) {
             int eid = q.poll();
            Employee e = map.get(eid);
            result += e.importance;
            for (Integer sid : e.subordinates) {
                q.add(sid);
            }
        }
        
        return result;
    }
}