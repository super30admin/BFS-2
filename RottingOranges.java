/*
Author: Akhilesh Borgaonkar
Problem: Return the minimum number of minutes that must elapse until no cell has a fresh orange.
    If this is impossible, return -1 instead.
Approach: Using BFS approach here to reach fresh oranges in 4 directions. Get the number of position of already rotten oranges.
    Store the rotten oranges in a queue. For every orange in the queue get the neighboring oranges in adjacent directions
    and mark them as rotten if they are not exceeding the edges of grid and not already rotten.
    While doing this increment the time counter and decrement number of fresh oranges counter. If the fresh oranges counter
    is zero then return time counter - 1 else return -1.
Time Complexity: O(n) where n is rows*columns of given grid.
Space Complexity: constant
*/

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static int orangesRotting(int[][] grid){

        int rn = grid.length;
        int cn = grid[0].length;
        Queue<int[]> rotten = new LinkedList<int[]>();
        int fresh=0;
        int time=0;
        int dir[][] = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i=0; i<rn; i++) {
            for(int j=0; j<cn; j++){
                if(grid[i][j]==2)
                    rotten.add(new int[]{i,j});
                else if(grid[i][j]==1)
                    fresh++;
            }
        }

        if(rotten.isEmpty())
            return 0;
        while(!rotten.isEmpty()){
            ++time;
            int rsize = rotten.size();
            for(int i=0 ; i<rsize; i++) {
                int[] current = rotten.remove();
                for (int[] directions : dir) {
                    int x = current[0] + directions[0];
                    int y = current[1] + directions[1];
                    //check for neighboring oranges
                    if (x < 0 || y < 0 || x >= rn || y >= cn || grid[x][y] == 0 || grid[x][y] == 2)
                        continue;   //check corners of grid, presence of orange and if orange is already rotten

                    grid[x][y] = 2;
                    rotten.add(new int[]{x, y});

                    fresh--;
                }
            }
        }

        if(fresh==0)
            return time-1;
        return
                -1;
    }

    public static void main(String[] args) {
        int[][] input = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(input));
    }

}
