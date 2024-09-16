/*
// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};
*/
// Time Complexity - O(n)
// Space Complexity - O(n) - BFS
//                   O(n) -  DFS
class Solution {
    Map<Integer,Employee> map;
    public int getImportance(List<Employee> employees, int id) {

        if(employees.size() == 0){
            return 0;
        }
        map =new HashMap<>();
        for(Employee e : employees){
            map.put(e.id,e);
        }
        // return dfs(id);
        return bfs(id);
    }

    //BFS
    private int bfs(int id){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        int result=0;

        while(!queue.isEmpty()){
            int eid = queue.poll();
            Employee e = map.get(eid);
            result += e.importance;
            for(int jr : e.subordinates){
                queue.add(jr);
            }
        }
        return result;
    }

    // DFS
    private int dfs(int id){
        Employee e = map.get(id);
        int result = e.importance;
        for(int eid : e.subordinates){
            result += dfs(eid);
        }
        return result;
    }
}