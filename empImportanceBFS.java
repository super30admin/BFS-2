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
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map=new HashMap<>();
        int result=0;
        for(Employee e:employees)
        {
            map.put(e.id,e);
        }
        Queue<Integer> q=new LinkedList<>();
        q.add(id);
        while(!q.isEmpty())
        {
            Employee e=map.get(q.poll());
            result+=e.importance;
            for(int i:e.subordinates)
            {
                q.add(i);
            }
        }
        
        return result;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)