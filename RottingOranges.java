// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        // We need to rot all adjascent oranges at once, hence we need BFS
        int m = grid.length;

        if(m == 0){
            return 0;
        }

        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();

        int countOf1 = 0;

        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if(grid[i][j] == 1){
                    countOf1 ++;
                } else if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }

        if(countOf1 == 0){
            return 0;
        }

        int time = -1;
        int size = 0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!q.isEmpty()){

            size = q.size();
            for(int i = 0; i < size; i++){
                int curr[] = q.poll();
                for(int[] dir: dirs){
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];

                    if(x >= 0 && x < m && y>=0 && y < n && grid[x][y] == 1){
                        grid[x][y] = 2;
                        q.add(new int[]{x,y});
                        countOf1--;
                    }
                }
            }

            time++;
        }

        if(countOf1 > 0){
            return -1;
        }

        return time;

    }
}
