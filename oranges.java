// time: O(n)
// space; O(n)
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null|| grid.length==0) return 0;
        int time=0;
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int freshOranges=0;
        int rottenOranges=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1) freshOranges++;
                if(grid[i][j]==2) 
                {
                    queue.add(new int[]{i,j});
                    rottenOranges++;
                }    
            }
        }
        if(rottenOranges==0 && freshOranges==0) return 0;
        int[][] dirs={{-1,0},{1,0},{0,1},{0,-1}};
        // through bfs we are checking all neighbous
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                int[] rotten=queue.poll();
                for(int[] dir: dirs)
                {
                    int r=rotten[0]+dir[0];
                    int c=rotten[1]+dir[1];
                    if(r>=0 && r<n && c>=0 && c<m && grid[r][c]==1)
                    {
                        grid[r][c]=2;
                        queue.add(new int[]{r,c});
                        freshOranges--;
                    }
                }
            }
            time++;
        }
        if(freshOranges==0) return time-1;
        return -1;
        
    }
}