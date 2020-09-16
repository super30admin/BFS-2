// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :
// 	not a intuitive solution

// Your code here along with comments explaining your approach

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0){
            return 0;
        }
        Map<Integer, Employee> empMap = new HashMap<>();
        for(Employee e : employees){
            empMap.put(e.id, e);
        }
            
        return bfs(empMap.get(id), empMap);
    }
    
    int bfs(Employee emp,  Map<Integer, Employee> empMap){
        Queue<Employee> q = new LinkedList<>();
        q.offer(emp);
        int impValue = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Employee currEmpl = q.poll();
                impValue += currEmpl.importance;
                
                for(Integer id: currEmpl.subordinates){
                    q.offer(empMap.get(id));
                }
            }
        }
        
        return impValue;
    }
}