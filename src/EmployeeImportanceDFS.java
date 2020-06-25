
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};

TC: O(n)
SP: O(n)
//better solution as using  stack
*/

class Solution {
    int result;
    HashMap<Integer, Employee> map;

    public int getImportance(List<Employee> employees, int id) {
        if(employees == null) return 0;
        map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id,e);
        }
        dfs(id);

        return result;
    }

    private void dfs(int eid){
        //base
        //logic
        Employee e=map.get(eid);
        result += e.importance;

        for(int subId : e.subordinates){
            dfs(subId);
        }
    }
}

