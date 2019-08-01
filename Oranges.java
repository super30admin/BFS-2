//Time:O(n2) orO(m*n)
//space:O(n)
class Solution {
    public int orangesRotting(int[][] grid) {
        
        int freshCount =0;
        Queue <int[]> queue = new LinkedList<>(); //We need to put i,j value hence array
        
        for(int i=0; i<grid.length;i++)
            for(int j =0;j<grid[0].length;j++)
            {
                if(grid[i][j]==2)
                    queue.offer(new int[]{i,j});
                else if(grid[i][j]==1)
                    freshCount++;
            }
        
          //if count of fresh oranges is zero --> return 0 
        if(freshCount == 0) return 0;
        int timer = 0; //This is the count
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            
           for(int i = 0 ; i < size ; i++) {
                int[] point = queue.poll();
            for(int dir[] : dirs) {
           
             int x = point[0] + dir[0];
             int y = point[1] + dir[1];
             //if x or y is out of bound
             //or the orange at (x , y) is already rotten
             //or the cell at (x , y) is empty
             //we do nothing
             if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] == 2) continue;
            //mark the orange at (x , y) as rotten
                    grid[x][y] = 2;
            //put the new rotten orange at (x , y) in queue
                    queue.offer(new int[]{x , y});
            //decrease the count of fresh oranges by 1
                    freshCount--;
           
        }
               
        }
            timer++;
        }
        if(freshCount>0) return -1;
        return timer-1;
    }
}
