//time complexity:O(m*n)
//space complexity:O(m*n)
/*Approach 
-going through the matrix to count number of fresh ornages and store coordinates of rotten ones in the queue
-taking size of the queue and processing elements one by one i.e taking rotten orange and making its neighbours
rotten per iteration while keeping a count(time)
-As soon as a coordinate represents rotten orange we put it in the queue so that it is processed in the next
iteration
-at last if fresh orange count is 0 we will return time else -1
*/

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){return -1;}
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)fresh++;
                if(grid[i][j] == 2)q.add(new int[]{i,j});
            }
        }
        if(fresh == 0)return 0;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i <size;i++){
               int[] curr = q.poll();
               for(int[] dir : dirs){
                int r = curr[0] + dir[0];
                int c  = curr[1]+dir[1];
                if(r >= 0 && r < grid.length && c >= 0 && c <grid[0].length){
                    if(grid[r][c] == 1){
                    fresh--;
                    grid[r][c] = 2;
                    q.add(new int[]{r,c});
                    }
                }
            } 
        }   
        time++;
    }
        
        if(fresh != 0)return -1;
        return time-1;
    }
    public static void main(String args[]){
        RottenOranges obj = new RottenOranges();
        System.out.println(obj.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }

}