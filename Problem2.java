//Time Complexity : O(N^2)
//Space Complexity : O(1)


class Solution {
    public int orangesRotting(int[][] grid) {
        
        if(grid == null)
            return 0;
        
        int nrows = grid.length;
        int ncols = grid[0].length;
        int size = 0;
        
        int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};
        int freshOranges = 0;
        
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        
        for(int i=0;i<nrows;i++)
        {
            for(int j=0;j<ncols;j++)
            {
                if(grid[i][j] ==2)
                {
                    queue.add(new Pair(i,j));
                }
                else if(grid[i][j] == 1)
                {
                    freshOranges +=1;
                }
            }
        }
        
        if(freshOranges == 0) return 0;
        
        int time = -1;
        while(!queue.isEmpty())
        {
            size = queue.size();
            
            for(int i=0;i<size;i++)
            {
               Pair<Integer,Integer> cell =  queue.poll();
                int row = cell.getKey();
                int col = cell.getValue();

                for(int[] dir:dirs)
                {
                    int x = row+dir[0];
                    int y = col+dir[1];
                    if(isValid(x,y,grid))
                    {
                        grid[x][y] = 2;
                        freshOranges--;
                        queue.add(new Pair(x,y));
                    }
                }     
            }
            
           
            time +=1;
        }
        
        return freshOranges ==0?time:-1;
    }
    
    private boolean isValid(int x, int y, int[][] grid)
    {
        int nrows = grid.length;
        int ncols = grid[0].length;
        if(x >= 0 && x<nrows && y>=0 && y<ncols && grid[x][y]==1)
            return true;
        else 
            return false;
    }
}