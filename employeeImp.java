//time complexity O(n) n is the no. of nodes
//space comlexity O(n) worst case skewed graph
//APPROACH: DFS

class Solution {
    int result = 0;
    public int getImportance(List<Employee> employees, int id) {
        // Hashmap<Integer, Employee> hmap = new Hashmap<>();
        HashMap <Integer, Employee> hmap = new HashMap<>();
        for(Employee em: employees){
            hmap.put(em.id, em);
        }
        dfs(hmap, id);
        return result;
    }

    private void dfs(HashMap<Integer, Employee> hmap, int id){
        Employee em = hmap.get(id);
        int imp = em.importance;
        result += imp;
        List<Integer> subord = em.subordinates;
        for(int sid: subord){
            dfs(hmap, sid);
        }
    }
}

//time complexity O(n)
//space complexity O(n)
//APPROACH: BFS

class Solution {
    int result = 0;
    HashMap <Integer, Employee> hmap;
    Queue<Integer> q = new LinkedList<>();
    public int getImportance(List<Employee> employees, int id) {
        // Hashmap<Integer, Employee> hmap = new Hashmap<>();
        hmap = new HashMap<>();
        for(Employee em: employees){
            hmap.put(em.id, em);
        }
        q.add(id);
        bfs(id);
        return result;
    }
    private void bfs(int id){
        while(!q.isEmpty()){
            int curr = q.poll();
            Employee emp = hmap.get(curr);
            result += emp.importance;
            List<Integer> sub = emp.subordinates;
            for(int sb: sub){
                q.add(sb);
            }
        }
    }
}
