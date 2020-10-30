/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

//TC: O(n)
//SC: O(n)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        
        Queue<Integer> q = new LinkedList();
        q.add(id);
        int imp = 0;
        while(!q.isEmpty()){
            int eid = q.poll();
            Employee e = map.get(eid);
            imp += e.importance;
            for(int sub : e.subordinates){
                q.add(sub);
            }
        }
        return imp;
    }
}

//TC: O(n)
//SC: O(n)
class Solution {
    int result; Map<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        dfs(id);
        return result;
    }
    private void dfs(int id){
        Employee e = map.get(id);
        result += e.importance;
        for(int sub : e.subordinates){
            dfs(sub);
        }
    }
}
