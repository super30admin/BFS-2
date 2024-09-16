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
    int result=0;
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map=new HashMap<>();
        
        for(Employee e:employees)
        {
            map.put(e.id,e);
        }
        dfs(map,id);
        return result;
    }
    
    private void dfs(HashMap<Integer,Employee> map,int id)
    {
        Employee data=map.get(id);
        result+=data.importance;
        for(int i:data.subordinates)
        {
            dfs(map,i);
        }
    }
}

// Time Complexity: O(n)
// Space Complexity: O(n)