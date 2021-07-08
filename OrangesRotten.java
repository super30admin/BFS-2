// Time Complexity : O(n) where n is the number of elements(all types) in the matrix
// Space Complexity : O(n) as there would be maximum n coordinates in the queue at a particular time
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  None
/* Your code here along with comments explaining your approach: DFS is practically difficult and doesnt make sense intuitively. We would go with BFS
since we are tol that the neighbor oranges get rotten every minute means we only care about the neighbors. We would insert all the rotten oranges indices
into the queue. We fetch the pairs one by one, and use the dirs array to check the neighbors if they contain any fresh oranges. If yes, then 
decrement the fresh oranges as they are going to be dead now, Add the new rotten oranges to the queue to be processed for its neighbors in the next minute.
We maintain size pointer since we want to process a certain set of neighbors considering the time. If the fresh oranges are not there, implies
the matrix is empty and return the minutes, else return -1.
*/

// DFS
class Solution {
    class Pair{
        int row;
        int column;
        Pair(int r, int c){                                 //Coordinates of the matrix cells
            this.row = r;
            this.column = c;
        }
        public int getRow(){
            return this.row;
        }
        public int getColumn(){
            return this.column;
        }
    }
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0){return 0;}                 // Base case
        int fresh = 0;
        int minute  = 0;
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){                                    // Put rotten oranges in the queue
                    queue.add(new Pair(i, j));
                } else if(grid[i][j] == 1){
                    fresh++;                                            // Count the fresh oranges
                }
            }
        }
        if(fresh==0){return 0;}                                         // If no fresh oranges, I am good, return 0!
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};               // Neighbors check
        while(!queue.isEmpty()){
            int size = queue.size();                                // size pointer to check on certain set of fresh oranges at a time
            System.out.println(size);
            for(int k =0; k < size; k++){
            Pair fetch = queue.poll();                              // Fetch the corrdinates
            int row = fetch.getRow();
            int col = fetch.getColumn();
            for(int[] dir : dirs){                                  // Check with the neighbor oranges
                int i  = row + dir[0];
                int j = col + dir[1];
            if(i >= 0 && j < grid[0].length && i < grid.length && j >= 0 && grid[i][j] == 1){               // If neighbor is a fresh orange
                    grid[i][j] = 2;                         // Gets Rotten
                    queue.add(new Pair(i, j));              // Add to the queue
                    fresh--;                                // No more a fresh orange
                }
            }
            }
            minute++;                                       // Time to take up the next batch
        }
        if(fresh != 0){                                 // At the end, there still are fresh oranges in the matrix
            return -1;                                  // I cant help it, return -1
        } else {
        return minute-1;                                // Return the number of minutes passed to rotten all the fresh oranges
        }
    }
}