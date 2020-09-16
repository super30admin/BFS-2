// Time Complexity : O(V) 
// Space Complexity : O(max(subordinates))
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
// BFS
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees==null)
            return 0;
        
        Map<Integer, Employee> map = new HashMap<>();
        
        Employee root = null;
        for(Employee e : employees){
            if(e.id == id){
                root = e;
            } 
            map.put(e.id, e);
        }
        
        if(root == null)
            return 0;
        
        int res =0 ;
        
        Queue<Employee> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Employee e = q.poll();
                res += e.importance;
                if(e.subordinates != null && e.subordinates.size()!=0){
                    for(int key : e.subordinates){
                        q.add(map.get(key));
                    }
                }
                
            }
        }
        return res;
    }
}