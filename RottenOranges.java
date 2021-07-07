/*
 * #994. Rotting Oranges
 * 
 * In a given grid, each cell can have one of three values:

1. the value 0 representing an empty cell;
2. the value 1 representing a fresh orange;
3. the value 2 representing a rotten orange.

Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 
Example 1:
Refer leetcode


Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Note:

1. 1 <= grid.length <= 10
2. 1 <= grid[0].length <= 10
3. grid[i][j] is only 0, 1, or 2.

 */


/*
 * Time Complexity: O (m*n) + O (N) -> explained in code comments section
 * 
 * Space Complexity: O (N) -> To store 'N' cells (i,j)th index but not all at the same time
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.BFS2;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
public int orangesRotting(int[][] grid) {
        
        // #1. Base condition
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        // #2. Initialize the fresh oranges count and time to 0
        int fresh = 0;
        int time = 0;
        
        // #3. Create a queue to store the (i,j) of the cell 
        Queue<int[]> queue = new LinkedList<int[]>();
        
        // #4. Traverse through the matrix to get fresh oranges count and (i,j) of cells with rotten oranges to initiate the queue
        // Time Complexity: O (m*n) -> To traverse through all matrix elements
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                // If we encounter 1, increment the count of fresh oranges
                if(grid[i][j] == 1){
                    fresh++;
                }
                else if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        
        // #5. Create a global direction array to explore where to go from current cell with rotten orange
        int[][] dirs = {{0,1}, {0,-1}, {-1,0}, {1,0}};
        
        // #6. Start the BFS level order traversal
        // Start processing the queue
        while(!queue.isEmpty()){
            
            // For level order traversal, get the length of a queue -> no of elements at current level
            int levelLength = queue.size();
            
            // We are checking for fresh oranges count before entering the for loop, because if we perform these steps after for loop, we will get wrong answer
            // Example, suppose if all the oranges in matrix are rotten but queue is still not empty, so we will enter while loop, then enter for loop, process the queue and after for loop, increment time value which will be wrong. So we are performing these steps here.
            
            
            if(fresh == 0){
                return time;
            }
            
            time += 1;
            
            // Time Complexity: O (N) -> To traverse through 'N' elements at current level
            for(int x = 0; x < levelLength; x++){
                
                // pop the front from queue
                int[] front = queue.poll();
                
                // explore the directions to go from that cell
                for(int[] dir : dirs){
                    int r = front[0] + dir[0];
                    int c = front[1] + dir[1];
                    
                    // Check if the new direction is in bounds and the cell at that direction has a fresh orange
                    if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1){
                        // Add {i,j} of that cell to queue
                        queue.add(new int[]{r,c});
                        // Change the fresh orange '1' to rotten '2'
                        grid[r][c] = 2;
                        // Decrement the count of fresh oranges
                        fresh -= 1;
                    }
                }
            }
            
        }
        
        // If count of fresh oranges is not 0, return -1
        if(fresh > 0){
                return -1;
            }
            
        return time; // return time taken to convert all fresh oranges to rotten
    }

}
