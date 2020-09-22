// Time Complexity : O(n) 
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int getImportance(List<Employee> employees, int id) {
       
        Map<Integer, Employee> hashmap = new HashMap<>();
        
        for(Employee emp: employees){
            hashmap.put(emp.id, emp);
        }
        
        Queue<Integer> queue = new LinkedList();
        queue.add(id);
        int output=0;
        
        while(!queue.isEmpty()){
          int front = queue.poll();
          output+=hashmap.get(front).importance;
            
          for(int sub: hashmap.get(front).subordinates){
              queue.add(sub);
          }
        }
        return output;   
    }
}