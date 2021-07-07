TC:O(n)
SC:O(n)

Runtime: 6 ms, faster than 53.98% of Java online submissions for Employee Importance.
Memory Usage: 47.2 MB, less than 95.24% of Java online submissions for Employee Importance.



class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0) return 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        q.add(id);
        int result =0;
        while(!q.isEmpty()){
            int eid = q.poll();
            Employee e = map.get(eid);
            result+= e.importance;
            for(int subid: e.subordinates){
                q.add(subid);
            }
        }
        return result;
    }
}
