/*
In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

 

Example 1:



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

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.
*/


// BFS Solution
// T: O(N * M)
// S: O(N * M)

class Solution {
    public int orangesRotting(int[][] grid) {
        
        int fresh = 0;
        Queue<int []> q = new LinkedList<>();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                
                if(grid[i][j] == 1) fresh++;
                
                if(grid[i][j] == 2)
                    q.add(new int[] {i, j});
            }
        }
        
        if(fresh == 0)  return 0;
        
        int hours = 0;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            hours++;
            
            while(size > 0){
                
                int[] temp = q.remove();
                
                int row = temp[0];
                int col = temp[1];
                
                if(row > 0 && grid[row - 1][col] == 1){
                    
                    grid[row - 1][col] = 2;
                    q.add(new int[] {row - 1, col});
                    fresh--;
                }
                
                if(row < grid.length - 1 && grid[row + 1][col] == 1){
                    
                    grid[row + 1][col] = 2;
                    q.add(new int[] {row + 1, col});
                    fresh--;
                }
                
                if(col > 0 && grid[row][col - 1] == 1){
                    
                    grid[row][col - 1] = 2;
                    q.add(new int[] {row, col - 1});
                    fresh--;
                }
                
                if(col < grid[0].length - 1 && grid[row][col + 1] == 1){
                    
                    grid[row][col + 1] = 2;
                    q.add(new int[] {row, col + 1});
                    fresh--;
                }
                
                size--;
            }
        }
        
        
        if(fresh == 0)  return --hours;
        else return -1;
    }
}