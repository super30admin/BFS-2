// Time complexity - O(n) worst case if we need to find the importance of the root employee which has all the other employees as its direct or indirect subordinates.
// Space Complexity - O(n) where n is the number of employees, since HashMap is used to store mapping of employee object mapping to its employee id so that the employee importance fetching is O(1) instead of O(n)
// This will be kind of graph scenario instead of a tree, since an employee can have more than one manager.
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
// BFS Solution
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() ==0){
            return 0;
        }
        HashMap<Integer,Employee> map = new HashMap<>();
        for(int i=0; i < employees.size(); i++){
            Employee emp = employees.get(i);
            map.put(emp.id,emp);  
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int result =0;
        while(!q.isEmpty()){
            int empid = q.poll();
            Employee emp = map.get(empid);
            result += emp.importance;
            List<Integer> sublist = emp.subordinates;
            for(int i=0;i < sublist.size();i++){
                q.add(sublist.get(i));
            }
        }
        
        return result;  
    }
}
