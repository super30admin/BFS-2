//Time Complexity : O(m*n) m and n being width and height of the matrix
//Space Complexity : O(m) or O(n) Maximum elements in the queue
//Runs successfully on leetcode
//No Problem

//Here we will be maintaing a count of total fresh oranges that needs to be rotten
//We will use bfs appraoch where we will be putting rotten oranges in queue and if there are any fresh oranges
//In the four directions we'll make the rotten. We'll keep this loop running till the queue is empty
//If there are any fresh oranges left, we'll return -1, otherwise the iterations it took for the queue to get empty


import java.util.LinkedList;
import java.util.Queue;

public class BFS_2_Problem_2_rottenOrange {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0 ) return -1;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0 ; i < grid.length ; i ++)
        {
            for(int j = 0 ; j < grid[0].length ; j ++)
            {
                if(grid[i][j] == 1)
                {
                    fresh++;
                }
                else if(grid[i][j] == 2)
                {
                    q.add(new int[]{i,j});
                }
            }
        }

        if(q.size()==0 && fresh == 0) return 0;

        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        int time = 0;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0 ; i < size ; i ++)
            {
                int[] curr = q.poll();
                for(int[] d : dirs)
                {
                    int l = d[0] + curr[0];
                    int m = d[1] + curr[1];
                    if(l>=0 && l<= grid.length -1 && m>=0 && m<=grid[0].length -1
                            && grid[l][m]==1)
                    {
                        grid[l][m] = 2;
                        fresh--;
                        q.add(new int[]{l,m});
                    }
                }
            }
            time++;
        }
        if(fresh == 0)
        {
            return time-1;
        }
        else return -1;



    }
}
