//TC: O(mxn) SC:(mxn)
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> c = new LinkedList<>();
        int freshOranges =0;
        int totalMin =0;
        int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 2)
                {
                    r.add(i);
                    c.add(j);
                }
                else if(grid[i][j] == 1)
                    freshOranges++;
            }
        }

        if(freshOranges == 0) return 0;

        while(!r.isEmpty())
        {
            int size = r.size();
            for(int i=0;i<size;i++)
            {
                int row = r.poll();
                int col = c.poll();

                for(int[] dir : dirs)
                {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if(newRow>=0 && newCol>=0 && newRow<grid.length && newCol<grid[0].length && grid[newRow][newCol] == 1)
                    {
                        grid[newRow][newCol] = 2;
                        r.add(newRow);
                        c.add(newCol);
                        freshOranges--;
                    }
                }
            }
            totalMin++;
        }
        if(freshOranges!=0) return -1;

        return totalMin-1;
    }
}