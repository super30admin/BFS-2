// 994.
//BFS based approach as oranges rot in layers(4 neighbours)
//time - O(m * n) 
//space - O(m * n) - max queue size if all oranges are rotten at start
class Solution {
    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        int time = 0;
        
        Queue<int[]> support = new LinkedList<>();
        
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(grid[i][j] == 1) //fresh
                {
                    freshOranges++;
                }
                if(grid[i][j] == 2) //rotten
                {
                    int[] rotten = {i, j};
                    support.offer(rotten); //initially process all the rotten oranges in first layer
                }
            }
        }
        
        if(freshOranges == 0)
        {
            return 0;
        }
        //initially push all rotten oranges into queue
        //do bfs, and change fresh orange neighbours to rotten and insert into queue 
        //increment time
    
        while(!support.isEmpty())
        {
            int layerSize = support.size();
            for(int i = 0; i < layerSize; i++)
            {
                int[] currentOrange = support.poll();
                int[][] neighbours = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; //4 neighbours
                for(int[] neighbour : neighbours)
                {
                    int row = currentOrange[0] + neighbour[0];
                    int column = currentOrange[1] + neighbour[1];
                    neighbour[0] = row;
                    neighbour[1] = column;
                    
                    if(row >= 0 && row < m && column >= 0 && column < n) //neighbour within bounds
                    {
                        if(grid[row][column] == 1) //if fresh make it rotten and insert into queue
                        {
                            grid[row][column] = 2; //make rotten to avoid processing of same orange 
                            support.offer(neighbour);
                            freshOranges--;
                        }
                    }
                }
            }
            time++;
        }
        
        if(freshOranges > 0)
        {
            return -1;
        }
        return time - 1;
    }
}
