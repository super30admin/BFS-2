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
/*
Time Complexity-O(N)
Space Complexity-O(N) 
where N is total number of employees.
*/
class Solution {
    private Map<Integer, Employee> map;
    private int importance=0;
    public int getImportance(List<Employee> employees, int id) {
        
        //I will be using HashMap to query employees quickly.
        map = new HashMap<>();
        for(Employee e: employees)
            map.put(e.id , e);
        
        //Now to find the total importance of an employee, it will be the importance of that employee, plus the         total importance of each of that employee's subordinates. 
        
        //DFS approach
        getImportanceDFS(id);
        getImportanceBFS(id);
        return importance;
    }
    private void getImportanceDFS(int eId){
        //employee to be processed
        Employee e = map.get(eId);
        importance += e.importance;
        //I check all subordinates of the employee in recursive dfs way.
        for(int id : e.subordinates)
            getImportanceDFS(id);
    }
    private void getImportanceBFS(int eid){
        Queue<Integer> q = new LinkedList<>();
        q.add(eid);
        
        while(!q.isEmpty()){
            Employee e  = map.get(q.poll());
            importance += e.importance;
            for(int id : e.subordinates)
                q.add(id);
        }
    }
}
