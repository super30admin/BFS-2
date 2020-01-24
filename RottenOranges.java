import sun.misc.Queue;

/*
Time Complexity: O(N)
Space Complexity: O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
*/ 
public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int row = grid.length,col = grid[0].length;
          int fresh = 0;
          Queue<int []> queue = new LinkedList<>();
  
          for(int i =-0; i < row; i ++){
              for(int j =0; j < col; j++){
                  if(grid[i][j] == 2){
                      queue.add(new int[]{i,j});
                  }
                  if(grid[i][j] == 1 ) {
                      fresh++;
                  }
              }
          }
          if(fresh == 0)
              return 0;
          int time = 0;
          int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0}};
          while(!queue.isEmpty()){
              int size = queue.size();
              for(int i =0; i < size; i++){
                  int []rotten = queue.poll();
                  for(int dir[] : dirs){
                      int r = rotten[0] + dir[0];
                      int c = rotten[1] + dir[1];
                      if(r >= 0 && r < row && c >= 0 && c < col && grid[r][c]== 1){
                          grid[r][c] = 2;
                          queue.add(new int[]{r,c});
                          fresh--;
                      }
                  }
              }
              time++;
          }  
          if(fresh > 0)
              return -1;
          return time > 0 ? time - 1 : 0;
      }      
}