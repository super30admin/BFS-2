// Time Complexity : O(n)
// Space Complexity : O(n) for hashmap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> res=new HashMap<>();
        int result=0;
        for(Employee emp:employees){
            res.put(emp.id,emp);
        }
        
        Queue<Integer> out=new LinkedList<>();
        out.add(id);
        while(!out.isEmpty()){
            int front=out.poll();
            result+=res.get(front).importance;
            
            for(int sub:res.get(front).subordinates){
                out.add(sub);
            }
        }
        return result;
    }
}