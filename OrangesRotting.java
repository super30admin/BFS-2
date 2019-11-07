/**
Daily Problem #60
Time Complexity : O(N)
Space Complexity : O(N) 
Did this code successfully run on Leetcode : No 
Any problem you faced while coding this: 
    Having trouble determining how to end the loop
 */

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue <Integer[]> q = new LinkedList<>();
        Set <Integer[]> visited = new HashSet<>();
        q.add(new Integer[]{0,0});
        int result = - 1;
        int count = 0;
        while(!q.isEmpty()){
            System.out.println("Count: " + count);
            printGrid(grid);
            int size = q.size();
            for(int i = 0; i< size; i++){
                Integer[] current = q.poll();
                if(visited.contains(current)) continue;
                visited.add(current);
                int row = current[0];
                int column = current[1];
                boolean orangeRotten = grid[row][column] == 2;
                count++;
                //check left bound
                if(column - 1 >= 0){
                    Integer[] left = new Integer[]{row, column - 1};
                    if(!visited.contains(left)){
                        if(orangeRotten && grid[row][column - 1] != 0) grid[row][column - 1] = 2; 
                        q.add(left);
                    }
                }
                //check right bound
                if(column + 1 < grid[row].length ){
                    Integer[] right = new Integer[]{row, column + 1};
                    if(!visited.contains(right)){
                        if(orangeRotten && grid[row][column + 1] != 0) grid[row][column + 1] = 2; 
                        q.add(right);
                    }
                    
                }
                
               //check upper bound
                if(row - 1 >= 0){
                    Integer[] up = new Integer[]{row -1, column};
                    if(!visited.contains(up)){
                        if(orangeRotten && grid[row - 1][column] != 0) grid[row - 1][column] = 2;
                        q.add(up);
                    }
                }
                
                //check lower bound
                if(row + 1 < grid.length){
                    Integer[] down = new Integer[]{row + 1, column};
                    if(orangeRotten &&  grid[row + 1][column] != 0) grid[row + 1][column] = 2;
                    if(!visited.contains(down)){
                        q.add(down);
                    }
                }
            }
        }
        
        return count;
    }

    public void printGrid(int[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------");
    }
}