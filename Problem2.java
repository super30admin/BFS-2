// Time Complexity :
//      m*n is the number of elements in the grid 
//		which are the number graph nodes denoted by V
//		and the edges of the graph by E.
//		worst case every element in the grid will rot
//      orangesRotting() - O(V) - O(m*n)
//      
// Space Complexity :
//      orangesRotting() - O(V) - O(m*n) 
//		we only check 4 edges which is a constant value
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return -1;
        
        //we will consider each cell 
        //in the grid as a graph vertex
        
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<Pair<Integer,Integer>> qu = new LinkedList<>();
        
        for(int i=0; i < m; ++i)
        {
            for(int j=0;j < n; ++j)
            {
                if(grid[i][j] == 2)
                {
                    qu.offer(new Pair(i,j));
                }
            }
        }
        
        int size = qu.size();
        int time = 0;
        
        while(!qu.isEmpty())
        {
            while(size > 0)
            {
                Pair<Integer, Integer> rotLoc = qu.poll();
                helper(rotLoc, qu, grid, m,n);
                --size;
            }
            
            if(qu.size() > 0)
            {
                ++time;
                size = qu.size();
            }
            
        }
        
        for(int i=0; i < m; ++i)
        {
            for(int j=0;j < n; ++j)
            {
                if(grid[i][j] == 1)
                {
                    return -1;
                }
            }
        }
        return time;
    }
    
    private void helper(Pair<Integer, Integer> loc, Queue<Pair<Integer, Integer>> qu, int[][] grid, int m, int n)
    {
        int[][] dirs = new int [][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
        
        int r = loc.getKey();
        int c = loc.getValue();
        
        for(int[] dir : dirs)
        {
            int i = r + dir[0];
            int j = c + dir[1];
            
            if( (i >= 0 && i < m) && (j >=0 && j < n) && grid[i][j] == 1 )
            {
                grid[i][j] = 2;
                qu.offer(new Pair(i,j));
            }
        }
    }
}