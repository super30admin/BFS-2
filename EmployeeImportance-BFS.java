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
    int result;
    HashMap<Integer,Employee> map = new HashMap<>();
    
    public int getImportance(List<Employee> employees, int id) {
        
        if (employees == null || employees.size() == 0){
            return 0;
        }
        
        for (Employee e : employees){
            map.put(e.id,e);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        
        while(!q.isEmpty()){
            int eid = q.poll();
            
            Employee e = map.get(eid);
            result += e.importance;
            
            List<Integer> subs = e.subordinates;
            
            if (subs != null){
                
                for(int subid : subs){
                    q.add(subid);
                }
            }
        }
        
        return result;
        
    }
    
    
}