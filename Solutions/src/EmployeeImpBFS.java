// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No
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
class EmployeeImpBFS {
    public int getImportance(List<Employee> employees, int id) {
        int imp=0;
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee employee : employees){
            map.put(employee.id,employee);
        }
        Queue<Employee> q =  new LinkedList<>();
        q.offer(map.get(id));
        while(!q.isEmpty()){
            Employee current = q.poll();
            imp+=current.importance;
            for(int subordinate : current.subordinates){
                q.offer(map.get(subordinate));
            }
        }
        return imp;
    }
}