//Time Complexity=O(M*N)
//Space Complexity=O(M*N), worst case all oranges are rotten

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0) return -1;
        int fresh=0,minutes=0;
        int m=grid.length,n=grid[0].length;
        Queue<int []> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2)
                {
                    q.add(new int[] {i,j});
                }
                if(grid[i][j]==1) fresh++;
            }
        }
        int [][]dir = {{0,1},{1,0},{0,-1},{-1,0}};
         if(fresh==0) return 0;
        while(!q.isEmpty())
        {
           int size=q.size();
           for(int i=0;i<size;i++)
            {
                int [] curr=q.poll();
                for(int []dirs:dir)
                {
                    int r=dirs[0]+curr[0];
                    int c=dirs[1]+curr[1];
                    if(r>=0 && r<m && c>=0 && c<n  && grid[r][c]==1)
                    {
                        grid[r][c]=2;
                        fresh--;
                        q.add(new int[]{r,c});
                    }
                }   
            }
            minutes++;
        }
        if(fresh!=0) return -1;
        return minutes-1;
    }
}