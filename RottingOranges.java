// Time Complexity : O(NxM)N=number of rows in matrix and M number of columns in matrix . 
// Space Complexity : O(NxM)N=number of rows in matrix and M number of columns in matrix. because we use extra data structure the queue
// and the worse case is all oranges are rotten.
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//the code uses the level order traversal we keep track of freshOranges and to the queue rotten oranges. After each level in bfs we add 1 to time.;
//Success
//Details 
//Runtime: 2 ms, faster than 97.48% of Java online submissions for Rotting Oranges.
//Memory Usage: 39 MB, less than 81.25% of Java online submissions for Rotting Oranges.

class Solution {
   public int orangesRotting(int[][] grid) {
        if (grid==null|| grid.length==0)
            return 0;
        int m=grid.length;int n = grid[0].length;
        int freshOranges=0;
        int time=0;
        Queue<int[]> queue= new LinkedList<>();
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (grid[i][j]==2)
                    queue.add(new int[]{i,j});
                if (grid[i][j]==1)
                    freshOranges++;
            }
        }
        if (freshOranges==0)
            return 0;
        int [][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i=0;i<size;i++){
                int [] cur=queue.poll();
                for (int[] dir:dirs){
                    int r= dir[0] +  cur[0];
                    int c= dir[1] +  cur[1];
                    if (r>=0 &&  r<m && c>=0 && c < n && grid[r][c]==1){
                     grid[r][c]=2;
                     queue.add(new int[]{r,c});
                     freshOranges--;
                    }
                
                }
            }
            time++;
            
        }
        if (freshOranges>0)
            return -1;
        return time -1;
    }
}