/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
//Time Complexity-O(n)
//Space Complexity-O(n)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee>map=new HashMap();
        for(Employee emp:employees)
        {
            map.put(emp.id,emp);
        }
        Queue<Employee>queue=new LinkedList();
        queue.add(map.get(id));
        int imp=0;
        while(queue.size()>0)
        {
            Employee emp=queue.poll();
            imp+=emp.importance;
            for(int sub:emp.subordinates)
            {
                queue.add(map.get(sub));
            }
        }
        return imp;
    }
}