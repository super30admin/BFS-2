// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Solved after class


// Your code here along with comments explaining your approach

//BFS
//T: O(N) iterate all elements in list
//S: O(N) store elements in hashmap and queue

class Solution1 {
    public int getImportance(List<Employee> employees, int id) {
        //use hashmap to map id with employee importance
       HashMap<Integer, Employee> map = new HashMap<>();
        
        //fill the hashmap
        for(Employee employee: employees){
            map.put(employee.id, employee);
        }
        
        //queue to ietrate and fetch required employee importance
        Queue<Employee> q = new LinkedList<>();
        q.add(map.get(id));
        
        //variable to store importance value
        int sum = 0;
        while(!q.isEmpty()){
            Employee e = q.poll();
            sum += e.importance;
            for(Integer subordinate: e.subordinates){
               q.add(map.get(subordinate));  
            }
            
        }
        
        return sum;
    }
}


//DFS
//T: O(N)
//S: O(N) recursive stack call

class Solution {
    public int getImportance(List<Employee> employees, int id) {
     
        HashMap<Integer, Employee> map = new HashMap<>();
        
        for(Employee employee: employees){
            map.put(employee.id, employee);
        }
        
        
        return dfs(map, id);
    }
    
    private int dfs(HashMap<Integer, Employee> map, int id){
        Employee curr = map.get(id);
        
        int sum = curr.importance;
        
        for(Integer subordinate: curr.subordinates){
            sum += dfs(map, subordinate);
        }
        
        return sum;
    }
    
}

