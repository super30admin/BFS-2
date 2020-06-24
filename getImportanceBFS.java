// Time Complexity :O(n) n length of the employees list;
// Space Complexity :O(n) n length of the employees list which is to be added in the HashMap and
// could also be the worst case for the queue
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null) return 0;
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees){
            map.put(e.id,e);
        }
        int result = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int curr = q.poll();
            Employee e = map.get(curr);
            result += e.importance;
            for(int sub : e.subordinates){
                q.add(sub);
            }
        }
        
        return result;
        
    }
}