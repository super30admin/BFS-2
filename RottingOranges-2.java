/*
Author: Akhilesh Borgaonkar
Problem: LC 994. Rotting Oranges (BFS-2)
Approach: Using iterative BFS approach here.
Time Complexity: O(m*n) where m and n are vertical and horizontal length of input grid.
Space complexity: O(n) where n is total number of oranges in the grid.
LC verified.
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        
        int minutes = 0;
        int fresh = 0;

        //base case
        if(grid.length == 0 || grid[0].length == 0)
            return minutes;
        //maintaining a queue to perform BFS
        Queue<int[]> q = new LinkedList<>();
        //finding the number of fresh and rotten oranges. Putting rotten oranges in the queue for BFS
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==2)
                    q.add(new int[]{i,j});
                if(grid[i][j]==1)
                    fresh++;
            }
        }
        //if no fresh eligible oranges found then return 0
        if(fresh == 0)
            return 0;
        //directions array for adjacent neighbors
        int[][] dirs = { {0,1}, {1,0}, {-1,0}, {0,-1} };
        //perform BFS on neighbors
        while(!q.isEmpty()){
            int size = q.size();
            //poping the rotten oranges put in queue
            for(int k=0; k<size; k++){
                int[] curr = q.poll();
                for(int[] dir : dirs){              //getting neighboring coordinates
                    int i = dir[0] + curr[0];
                    int j = dir[1] + curr[1];
                    if(i>=0 && j>=0 && i<grid.length && j<grid[0].length && grid[i][j]==1){ //checking if the coordinates are valid and fresh orange is present
                            q.add(new int[]{i,j});  //put in the queue
                            grid[i][j]=2;           //mark it rotten
                            fresh--;                //reduce number of total fresh oranges as current is marked rotten now
                    }
                }
            }
            
            minutes++;      //add time to total minutes counter
        }
        
        if(fresh != 0)
            return -1;      //if fresh oranges still remaining in the grid to be rotten then it was found unreachable
        return minutes>0 ? minutes-1 : 0;   //else return the minutes counter         
        
    }
}