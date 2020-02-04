// S30 Big N Problem #60 {Medium}
// 994. Rotting Oranges
// Time Complexity :O(m*n) where m and n are the number of rows and columns of the matrix
// Space Complexity :O(m*n) where m and n are number of rows and columns of the matrix (stored in queue)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None

// Your code here along with comments explaining your approach
// BFS solution
class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        if(grid==null || m ==0) return 0;
        int n=grid[0].length;
        int fresh=0;
        Queue <int []> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2) q.add(new int[] {i,j});
                if(grid[i][j]==1) fresh++;
            }
        }
        
        int minutes=0;
        int [][]dirs={{0,1},{0,-1},{-1,0},{1,0}};
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int [] rotten=q.poll();
                for(int []dir:dirs){
                    int r=rotten[0]+dir[0];
                    int c=rotten[1]+dir[1];
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c]==1){
                        grid[r][c]=2;
                        q.add(new int[]{r,c});
                        fresh--;
                    }
                }
            }
            minutes++;
        }
        if(fresh>0) return -1;
        return minutes>0 ? minutes-1:0; //minutes-1 because for first level - oranges are already rotten 
    }
}