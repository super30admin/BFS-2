package S30.BFS_2;

import java.util.LinkedList;
import java.util.Queue;

/*BFS Solution
Time Complexity : O(MxN)
Space Complexity : O(MxN)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/

public class RottingOranges {

    public int orangesRotting(int[][] grid) {

        int R = grid.length;
        if(R == 0) return 0;
        int C = grid[0].length;
        int freshCount = 0;
        int[][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }

        int time = 0;
        if(freshCount == 0) return time;
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i = 0; i < size; i++){

                int[] curr = queue.poll();

                for(int[] dir : dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];

                    if(r >=0 && c >= 0 && r < R && c < C){
                        if(grid[r][c] == 1){
                            grid[r][c] = 2;
                            queue.offer(new int[]{r,c});
                            freshCount--;
                        }
                    }
                }
            }
            time++;
            if(freshCount == 0) return time;



        }

        return freshCount == 0? time : -1;
    }
}
