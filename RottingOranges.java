package Nov11;

import java.util.LinkedList;
import java.util.Queue;

class RottingOranges {
    public int orangesRotting(int[][] grid) {

/*
     Time Complexity: O(m*n)
     We will iterate through all m*n nodes of the grid to find fresh oranges count and find the indexes of nodes with rotten oranges and insert those indexes as a pair in the queue for BFS
     Next, in BFS, if we have fresh oranges in every cell except 1, we need to process each of those nodes again.
    
     Space Complexity: O(m*n) 
    Because from 1 rotten node, 4 neighbor nodes can get rotten(if they all have fresh oranges initially). Each of those 4 nodes can further rot 4*4 neighbor nodes. This can very soon cover the entire grid of m*n. 
   
     Did this code successfully run on Leetcode : Yes
    
     Any problem you faced while coding this : No
        
     Approach: 
     DFS used to traverse the given tree till nodes with both x and y values found. 
     Then level and parents of nodes with value as x and y are compared to decide if the given nodes are cousins or not.
               
*/ 
       
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        // traverse the grid:
        // a) to find fresh oranges count 
        // b) to find the indexes of nodes with rotten oranges and insert those indexes as a pair in the queue for BFS
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                }
            }
        }
        
        // if no fresh oranges in the given grid, return 0 
        if (fresh == 0){
            return 0;
        }
        
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        
        // Using BFS approach, set all fresh neighbors to rotten nodes as rotten and reduce fresh count
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int[] cur = queue.poll();
                for(int[] dir: dirs) {
                    int row = cur[0] + dir[0];
                    int col = cur[1] + dir[1];
                    if (row >= 0 && row < m && col >= 0 && col < n && grid[row][col] == 1) {
                        queue.add(new int[]{row, col});
                        grid[row][col] = 2;
                        fresh--;
                    }
                }
            }
            time++;
        }
        
        // If some oranges have been left fresh after whole of BFS traversal of the grid, so as per problem statement, return -1 in that case
        if (fresh > 0) {
            return -1;
        }
        
        // time is incremented by 1 for the first time when while loop runs with given set of rotten nodes for processing, This shouldn't be counted since given set of rotten nodes is at time 0.So, we return time-1 from the function.
        return time-1;
        
    }
}