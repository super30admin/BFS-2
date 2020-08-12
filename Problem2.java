// Time Complexity : O(nm)
//      n: row length
//      m: column length
//   Worst case  (n-1)*m rotten oranges
// Space Complexity : 0(nm)
//      n: row length
//      m: column length
//  Worst case  (n-1)*m rotten oranges in Queue
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

import java.util.LinkedList;
import java.util.Queue;

// Your code here along with comments explaining your approach
// Using BFS as we need to process level by level.
// Also we require time elpased as oranges get rottens(requires size).
// Each change in state affects other neigbhor's state.
// NOTE:In BFS, we process node before adding to queue so visited not required.
class Problem2 {

    /** find minutes elapsed */
    public int orangesRotting(int[][] grid) {

        // time elapsed
        int time = -1;
        // edge case
        if(grid == null || grid.length == 0)
            return 0;
        
        // track fresh oranges ->helps us to tackle unreach-able orange
        int freshCount = 0;
        // processing rotten oranges
        Queue<int[]> myQueue = new LinkedList<>();

        // intialize
        int rowLength = grid.length;
        int colLength = grid[0].length;

        // find fresh and rotten oranges
        for(int i=0;i<rowLength; i++){
            for(int j=0; j<colLength; j++){
                // fresh
                if(grid[i][j] == 1)
                    freshCount++;
                // rotten
                else if (grid[i][j] == 2)
                    myQueue.add(new int[]{i, j});
            }
        }
        
        // if no fresh oranges
        if(freshCount == 0)
            return 0;
        
        // neighbors of each orange -> left, right, up, down
        int[][] neighbors = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};


        // process rotten oranges
        while(!myQueue.isEmpty()){
            
            // level order
            int size = myQueue.size();
            
            while(size != 0){
                
                // get current
                int[] current = myQueue.poll();
                
                // process neighbor
                for(int[] neighbor: neighbors){
                    
                    int row = current[0] + neighbor[0];
                    int col = current[1] + neighbor[1];

                    // within bounds
                    if(row >= 0 && row < rowLength && col >= 0 && col < colLength){
                        
                        // fresh
                        if(grid[row][col]==1){
                            //  change to rotten and add to queue
                            grid[row][col] = 2;
                            freshCount--;
                            myQueue.add(new int[]{row, col});
                            // We process node before adding to queue so visited not required.
                        }
                    }     
                } 
                size--;
            }
            
            // time for next min
            time++;
        }
        
        // all fresh are processed
        if(freshCount == 0)
            return time;
        else
            return -1;
    }
}