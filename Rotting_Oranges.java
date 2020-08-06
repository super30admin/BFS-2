import java.util.LinkedList;
import java.util.Queue;

class Rotting_Oranges {
	//Approach: BFS
	//1. Here we traverse through the grid and keep a count of fresh oranges, and keep adding rotten oranges to the queue. 
	//2. We then process the rotten oranges by polling from the queue, in that way we will look on the 4 directions and if there are any fresh oranges, we make it rotten and add to queue.
	//3. Hence we keep doing this while the queue is not empty. At the end if the fresh count is not zero. then we return -1 or else we return the time which we have increase after processing each level.
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0)
            return -1;
        int fresh = 0;
        int[][] direction = {{0,-1}, {0,1}, {-1, 0}, {1,0}};
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == 1)
                    fresh++;
                else if(grid[i][j] == 2)
                    queue.add(new int[]{i,j});
            }
        }
        if(fresh == 0)return 0;
        int time = 0;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i=0;i<size;i++)
            {
                int[] currRotten = queue.poll();
                for(int[] dir:direction)
                {
                    int x = currRotten[0]+dir[0];
                    int y = currRotten[1] + dir[1];
                    if(x >= 0 && x < grid.length && y >=0 && y< grid[0].length && grid[x][y] == 1)
                    {
                        grid[x][y] =2;
                        fresh--;
                        queue.add(new int[]{x,y});
                    }
                }
            }
            time++;
        }
        if(fresh != 0) return -1;
        return time-1;
    }
}

//Time Complexity : O(m * n) 
//Space Complexity : O(m * n) 
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :