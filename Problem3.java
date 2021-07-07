//time o(V+E)
//space o(h) height of the graph
//DFS
class Solution {
    HashMap<Integer,Employee> map;
    int result;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        if(employees == null)
            return 0;
        for(Employee e : employees) {
            map.put(e.id, e);
        }
        dfs(id);
        return result;
    }
    private void dfs(int id) {
        Employee obj = map.get(id);
        result = result + obj.importance;
        List<Integer> list = obj.subordinates;
        for(int i=0;i<list.size();i++) {
            dfs(list.get(i));
        }
    }
}

//BFS
//Time o(V+E)
//space width of the graph
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer,Employee> map = new HashMap<>();
        int result = 0;
        if(employees == null)
            return 0;
        for(Employee e : employees) {
            map.put(e.id, e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        while(!q.isEmpty()) {
            Employee e = map.get(q.poll());
            result = result + e.importance;
            List<Integer> list = e.subordinates;
            for(int i=0;i<list.size();i++) {
                q.add(list.get(i));
            }
        }
        return result;
    }
}