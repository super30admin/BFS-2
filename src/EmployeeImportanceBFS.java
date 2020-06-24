/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
TC: O(N)  SC: O(N) BFS solution */
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null) return 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id,e);
        }
        int result=0;
        Queue<Integer> q= new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int eid= q.poll();
            Employee e=map.get(eid);
            result += e.importance;
            for(int subId : e.subordinates){
                q.add(subId);
            }
        }return result;
    }
}