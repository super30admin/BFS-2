class Solution {
     // Time Complexity : O(m*n) m*n:we are visiting all matrix elements once
 // Space Complexity : O(m*n) worst case where all oranges are rotten initially
 // Did this code successfully run on Leetcode : Yes
 // Any problem you faced while coding this :


 // Your code here along with comments explaining your approach
 /*
 1. Use bfs method through queue and traverse till the point where oranges can be rotten when connected
 2. First add queue with all the rotten oranges and trreat them as one level, then their children so on.
 3. Use the timer and fresh oranges count 
 */
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length; int n = grid[0].length;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]==1)
                    fresh++;
                else if(grid[i][j]==2){
                    int[] a = {i,j};
                    q.add(a);
                }
            }
        }
        
        int[][] dirs ={{0,1},{1,0},{-1,0},{0,-1}};
        int time = 0;
        if(q.isEmpty() && fresh==0) return 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i =0;i<len;i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r>= 0 && r<m && c>=0 && c<n){
                    if(grid[r][c] == 1){
                        fresh--;
                        grid[r][c] = 2;
                        int[] a = {r,c};
                        q.add(a);
                    }}
                }
            }
            time++;
        }
        if(fresh != 0) return -1;
        return time-1;        
    }
}