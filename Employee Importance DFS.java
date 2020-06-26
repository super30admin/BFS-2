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
    int result;
    public int getImportance(List<Employee> employees, int id) {
        
        if(employees==null) return 0;
        HashMap<Integer,Employee> map=new HashMap<>();
        
        for(Employee E:employees)
        {
            map.put(E.id,E);
        }
        result=0;
        dfs(id,map);
        return result;
    }
    private void dfs(int id, HashMap<Integer, Employee> map)
    {
        Employee e=map.get(id);
        result+= e.importance;
        for(int ids:e.subordinates)
        {
            dfs(ids,map);
        }
        
    }
}