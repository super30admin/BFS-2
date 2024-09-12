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
// time: O(n)
// space: O(n)
class Solution {
    int result=0;
    public int getImportance(List<Employee> employees, int id) {
        if(employees==null) return 0;
        HashMap<Integer,Employee> map=new HashMap<>();
        Queue<Integer> queue=new LinkedList<>();
        for(Employee e: employees)
        {
            map.put(e.id,e);
        }
        queue.add(id);
        while(!queue.isEmpty())
        {
            Integer i=queue.poll();
            Employee e=map.get(i);
            result+=e.importance;
            // tarversing all children
            for(int x : e.subordinates)
            {
                Employee emp=map.get(x);
                queue.add(emp.id);
            }
        }
        return result;
    }

}