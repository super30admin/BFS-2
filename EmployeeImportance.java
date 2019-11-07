//Time Complexity :O(N)
//Space Complexity :O(N)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope. solved using both dfs and bfs.


//Your code here along with comments explaining your approach
class Solution {
    int importance = 0;
    public int getImportance(List<Employee> employees, int id) {
        if(null == employees || 0 == employees.size()){return 0;}
        importance = 0;
        Map<Integer,Employee> idEmployeeMap = new HashMap<>();
        employees.stream().forEach(e->{idEmployeeMap.put(e.id,e);});
        dfs(idEmployeeMap,id);
        return importance;
    }
    public void dfs(Map<Integer,Employee> idEmployeeMap, int id){
        Employee e = idEmployeeMap.get(id);
        importance += e.importance;
        e.subordinates.stream().forEach(s->{dfs(idEmployeeMap,s);});
    }
     public int getImportance1(List<Employee> employees, int id) {
         if(null == employees || 0 == employees.size()){return 0;}
         int importance = 0;
         Map<Integer,Employee> idEmployeeMap = new HashMap<>();
         employees.stream().forEach(e->{idEmployeeMap.put(e.id,e);});
         Queue<Employee> q = new LinkedList<>();
         q.offer(idEmployeeMap.get(id));
         while(!q.isEmpty()){
             Employee e = q.poll();
             importance += e.importance;
             e.subordinates.stream().forEach(s->{q.offer(idEmployeeMap.get(s));});
         }
         return importance;
     }
}