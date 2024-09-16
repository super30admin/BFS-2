/**
Daily Problem #60
Time Complexity : O(N)
Space Complexity : O(N) 
Did this code successfully run on Leetcode : Yes 
Any problem you faced while coding this: 
    Was able to to solve once I learned logic for BFS on a grid from class 
 */

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Integer[]> q = new LinkedList<>();
        int freshOranges = 0;
        // Find coordinates for rotting oranges
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2) q.add(new Integer[]{i,j}); 
                else if(grid[i][j] == 1) freshOranges++;
            }
        }
        if(freshOranges == 0) return 0;
        if(q.isEmpty()) return -1;
        int count = 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Integer[] current = q.poll();
                int row = current[0];
                int column = current[1];
        
                //Check down
                if(validIndex(grid, row + 1, column) && grid[row + 1][column] == 1) {
                    q.add(new Integer[]{row + 1, column});
                    grid[row + 1][column] = 2;
                    freshOranges--;
                }
                //Check up
                if(validIndex(grid, row - 1, column) && grid[row - 1][column] == 1) {
                    q.add(new Integer[]{row - 1, column});
                    grid[row - 1][column] = 2;
                    freshOranges--;
                }
                
                //Check left
                if(validIndex(grid, row, column - 1) && grid[row][column - 1] == 1){
                    q.add(new Integer[]{row, column - 1});
                    grid[row][column - 1] = 2;
                    freshOranges--;
                }
                //Check right
                if(validIndex(grid, row, column + 1) && grid[row][column + 1] == 1){
                    q.add(new Integer[]{row, column + 1});
                    grid[row][column + 1] = 2;
                    freshOranges--;
                }
            }
            count++;
        }
        
        if(freshOranges > 0) return -1;
        return count == 0 ? 0 : count - 1;
        
    }
    
    private boolean validIndex(int[][] grid, int row, int column){
        if(row < 0 || row >= grid.length) return false;
        if(column >= grid[row].length || column < 0) return false;
        
        return true;
    }
    
}
