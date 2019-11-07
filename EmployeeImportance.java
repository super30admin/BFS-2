/**
Daily Problem #61
Time Complexity : O(N)
Space Complexity : O(N) 
Did this code successfully run on Leetcode : Yes 
Any problem you faced while coding this: 
 */

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees.size() == 0) return 0;
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id, e);
        }
        int importance = 0;        
        Queue<Integer> q = new LinkedList<>();

        q.add(id);
        
        // Level order traversal through list of subordinates for employee w/ given id
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i< size; i++){
                Employee current = map.get(q.poll());
                importance += current.importance;

                for(Integer subordinateId : current.subordinates){
                    q.add(subordinateId);
                }
            }
        }
        
        return importance;
    }
}
