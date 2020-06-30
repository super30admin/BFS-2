/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
//Time omplexity=O(N)
//Space Complexity=O(N), as we are storing all the employees in the hashmap
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map=new HashMap<>();
        for(Employee E:employees)
        {
            map.put(E.id,E);
        }
        int result=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(id);
        while(!q.isEmpty())
        {
            int eid=q.poll();
            Employee E=map.get(eid);
            result+=E.importance;
            for(int subId:E.subordinates)
                q.add(subId);
        }
        return result;
    }
}