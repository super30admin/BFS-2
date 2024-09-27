// Problem3 : Employee importance (https://leetcode.com/problems/employee-importance/)

// BFS
// T - O(n)
// S - O(n)
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null){
            return 0;
        }
        
        //build graph
        HashMap<Integer, Employee> graph = new HashMap<>();
        
        for(Employee e: employees){
            graph.put(e.id, e);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int res = 0;
        while(!q.isEmpty()){
            int eid = q.poll();
            Employee e = graph.get(eid);
            res += e.importance;
            
            List<Integer> subids = e.subordinates;
            if(subids != null){
                for(int subid: subids){
                    q.add(subid);
                }
            }
        }
        
        return res;
    }
}