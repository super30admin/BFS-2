/**
Daily Problem #60
Time Complexity : O(N)
Space Complexity : O(N) 
Did this code successfully run on Leetcode : No 
Any problem you faced while coding this: 
    Not passing all test cases 
 */

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Integer[]> q = new LinkedList<>();
        // Find coordinates for rotting oranges
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2) {
                    q.add(new Integer[]{i,j});                    
                }
            }
        }
        
        int count = -1;
        Set<Integer[]> visited = new HashSet<>();

        while(!q.isEmpty()){
            int size = q.size();
            count++;
            for(int i = 0; i < size; i++){
                Integer[] current = q.poll();
                visited.add(current);
                int row = current[0];
                int column = current[1];
                grid[row][column] = 2;
                
                //Check down
                if(validIndex(grid, row + 1, column)){
                    Integer[] down = new Integer[]{row + 1, column};
                    if(!visited.contains(down) && grid[row + 1][column] == 1) q.add(down);
                }
                //Check up
                if(validIndex(grid, row - 1, column)){
                    Integer[] up = new Integer[]{row - 1, column};
                    if(!visited.contains(up) && grid[row - 1][column] == 1) q.add(up);
                }
                
                //Check left
                if(validIndex(grid, row, column - 1)){
                    Integer[] left = new Integer[]{row, column - 1};
                    if(!visited.contains(left) && grid[row][column - 1] == 1) q.add(left);
                }
                //Check right
                if(validIndex(grid, row, column + 1)){
                    Integer[] right = new Integer[]{row, column + 1};
                    if(!visited.contains(right) && grid[row][column + 1] == 1) q.add(right);
                }
            }
        }
        
        // Check if there are any fresh oranges left;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        
        return count;
        
    }
    
    private boolean validIndex(int[][] grid, int row, int column){
        if(row < 0 || row >= grid.length) return false;
        if(column >= grid[row].length || column < 0) return false;
        
        return true;
    }
    
}