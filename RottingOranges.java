// Time Complexity : O(n^2) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
// BFS
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid==null)
            return -1;
        
        int m = grid.length;
        int n = grid[0].length;
        
        boolean visited[][] = new boolean[m][n];
        
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                    visited[i][j]=true;
                }
                if(grid[i][j] == 0){
                    visited[i][j]=true;
                }
            }   
        }
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        int min=0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int curr[] = q.remove();                
                for (int[] dir : directions) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x >=0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && !visited[x][y]) {
                        q.offer(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
            }
            if (q.size() != 0) {
                min++;
            }     
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]) 
                    return -1;
            }   
        }      
        return min;
    }
}
