// Time Complexity :O(nm) n and m are the length and breadth of the array; 
// Space Complexity :O(nm) n and m are the length and breadth of the array and in worst case all the 
// values in the matrix may be stored in the Queue.
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length ==0) return -1;
        int time = 0;
        int fresh = 0;
        int n = grid.length; int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 2) q.add(new int[]{i,j});
                if(grid[i][j] == 1) fresh ++;
            }
        }
        
        int[][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        
        if(q.isEmpty() && fresh==0) return 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                int[] curr = q.poll();
                for(int[] dir:dirs){
                    int r = curr[0]+dir[0];
                    int c = curr[1]+dir[1];
                    if(r<n && r>=0 && c<m && c>=0 && grid[r][c]!=2)
                    {
                        if(grid[r][c]==1){
                            grid[r][c] = 2;
                            fresh--;
                            q.add(new int[]{r,c});
                        }
                    }
                }
            }
            
            time++;
        }
        
        if(fresh>0) return -1;
        else return time-1;
    }
}