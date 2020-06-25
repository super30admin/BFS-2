// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach



class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null)
            return 0;
        int m= grid.length;
        int n= grid[0].length;
        
       int time = 0; 
        Queue<int [] > queue = new LinkedList<>();
        int freshCount  = 0 ;
        for(int i = 0; i < m ; i++){
           for(int j = 0 ; j < n ; j++){
             if(grid[i][j] == 1)  
               freshCount++;
              if(grid[i][j] == 2)
                  queue.add(new int[]{i,j});
           } 
        }
       if(queue.isEmpty() && freshCount == 0)
           return 0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!queue.isEmpty()){
             int length = queue.size();
             for(int i = 0 ; i < length ; i++){
                   int[] cur = queue.poll();
                  for(int[] dir : dirs)
                  { 
                      int row = cur[0]+dir[0];
                      int col = cur[1]+dir[1];
                      if(row>=0 && row< m && col>=0 && col< n && grid[row][col] == 1)
                      {
                          grid[row][col] = 2 ;
                          freshCount--;
                          queue.add(new int[]{row,col});
                      }
                }
        }
            time++;
    }
     if(freshCount > 0)
         return -1;
     return time-1;
}
}
