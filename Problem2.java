// Problem2 (https://leetcode.com/problems/rotting-oranges/)

// BFS
// T - O(mn)
// S - O(mn)
class Solution {
    
    public int orangesRotting(int[][] grid) {
        if(grid == null)  return -1;
        int m = grid.length;
        if(m == 0) return -1;
        int n = grid[0].length;
        
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) fresh ++;
                if(grid[i][j] == 2) q.add(new int[]{i, j});
            }
        }
        if(fresh == 0) return 0;
        int time = 0;
        int[][] dirs = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    
                    if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1){
                        fresh--;
                        grid[r][c] = 2;
                        q.add(new int[]{r, c});
                    }
                }
            }
            
            time++;
        }
        
        
        if(fresh > 0) return -1;
        
        return time > 0 ? time - 1 : -1;
    }
}

// DFS
// T - O(n)
// S - O(n)
class Solution {
    int res;
    HashMap<Integer, Employee> graph;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null) return 0;
        res = 0;
        //build graph
        graph = new HashMap<>();
        for(Employee e: employees){
            graph.put(e.id, e);
        }
        dfs(id);
        return res;
    }
    
    private void dfs(int eid){
        Employee e = graph.get(eid);
        res += e.importance;
        List<Integer> subids = e.subordinates;
        
        if(subids != null){
            for(int subid: subids){
                dfs(subid);
            }
        }
        
    }
}