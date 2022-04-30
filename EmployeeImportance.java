/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/
//TC : O(N) SC:O(N)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees==null||employees.size()==0) return 0;
        Map<Integer,Employee> mp = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        int totalImp = 0;
        for(Employee emp : employees)
        {
            mp.put(emp.id,emp);
        }
        q.add(id);

        while(!q.isEmpty())
        {
            Integer eID = q.poll();

            Employee e = mp.get(eID);
            totalImp+=e.importance;
            List<Integer> subList = e.subordinates;
            for(int i=0;i<subList.size();i++)
            {
                q.add(subList.get(i));
            }
        }

        return totalImp;
    }
}