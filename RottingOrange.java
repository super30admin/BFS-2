
//Time Complexity-O(n*m)
//Space Complexity-O(n*m)
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]>queue=new LinkedList();
        int freshOrangeCount=0;
        int min=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    freshOrangeCount++;
                }
                else if(grid[i][j]==2)
                {
                    queue.add(new int[]{i,j});
                }
            }
        }
        int[][]directions={{1,0},{0,1},{-1,0},{0,-1}};
        while(!queue.isEmpty())
        {
            int size=queue.size();
            if(freshOrangeCount==0)
            {
                return min;
            }
            min++;
            for(int i=0;i<size;i++)
            {
                int[] front=queue.poll();
                for(int[]dir:directions)
                {
                    
                    int row=front[0]+dir[0];
                    int col=front[1]+dir[1];
                    System.out.print(row+" "+col);
                    if(row>=0 && col<grid[0].length&&
                      row<grid.length&&col>=0 && grid[row][col]==1)
                    {
                        grid[row][col]=2;
                        queue.add(new int[]{row,col});
                        freshOrangeCount--;
                    }
                }
                
            }
        }
        if(freshOrangeCount>0)
        {
            return -1;
        }
        return min;
}
}