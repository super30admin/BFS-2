// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        HashMap<Integer,Employee> map = new HashMap<>();
        int importance = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        for(Employee employee : employees){
            map.put(employee.id ,employee);
        }
        while(!queue.isEmpty()){
              int cur = queue.poll();
              Employee e = map.get(cur);
               List<Integer> sub =  e.subordinates;
               importance+=e.importance;
            for(int i = 0 ; i< sub.size() ;i++){
                  queue.add(sub.get(i));
            }
            
        }
        return importance;
    }
}