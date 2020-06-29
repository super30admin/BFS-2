// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//BFS Solution
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if(employees==null){
            return 0;
        }
        HashMap <Integer, Employee> map=new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        int result=0;
        Queue <Integer> q=new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()){
            int eid=q.poll();
            Employee e=map.get(eid);
            result += e.importance;
            for(int subId : e.subordinates){
                q.add(subId);
            }
        }
        return result;
    }
}


//DFS Solution
class Solution {
    int result;
    HashMap<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        if(employees==null){
            return 0;
        }
        map=new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        dfs(id);
        return result;
    }
    private void dfs(int eid){
        Employee e=map.get(eid);
        result += e.importance;
        for(int subId : e.subordinates){
            dfs(subId);
        }
    }
}