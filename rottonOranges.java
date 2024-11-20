/*
* I will be traversing the whole grid to find out the positions of rotten oranges and compute the total num of orange as well, 
* I will be adding the positions of rotten oranges initially into the queue;
* Secondly, I wil dequeue oranges rotton at the first level  from the queue to get the position of a rotten orange. 
* Due to the infection, the fresh oranges near the rotten orange become rotten. 
* So I will be checking the cell in the left/right/top/down of the rotten orange, if it is a fresh orange, I enqueue it. 
* Continue to dequeue until all rotten oranges of last round are removed from the queue


Time Complexity - O(M*N) where M is number of rows and col is number of columns
Space Complexity- O(M*N) where M is number of rows and col is number of columns
*/
class Solution {
    int row , col;
    private class Cell{
        int x, y;
        public Cell(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private boolean isValidCell(int x , int y){
        return x >= 0 && x< row && y>= 0 && y< col;
    }
    public int orangesRotting(int[][] grid) {
        //edge case
        if(grid == null || grid.length ==0 ) return 0;
        
        row = grid.length;
        col= grid[0].length;
        int totalOranges = 0, time=0, rottonOranges = 0;
        Queue<Cell> q= new LinkedList<>();
        
        //calculate total oranges and put rotton oranges at each level into queue
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1 || grid[i][j]==2)
                    totalOranges++;
                if(grid[i][j] == 2)
                    q.add(new Cell(i,j));
            }
        }
        //if there are no rotton oranges in the 1st level other oranges can not be rotton 
        if (totalOranges == 0)  return 0;
        int [][]dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        
        while(!q.isEmpty() && rottonOranges< totalOranges) { 
            int size= q.size();
            rottonOranges += size;
            
            //all oranges are rotton
            if(rottonOranges == totalOranges)
                return time;        
            time++; 
            while(size > 0){
                Cell c= q.remove();
                //check all adjacent neighbors of rotton oranges, if they have fresh oranges , rot them .
                for(int [] dir :dirs){
                    int newX = c.x + dir[0];
                    int newY = c.y + dir[1];
                    if(isValidCell(newX, newY) && grid[newX][newY] == 1){
                         q.add(new Cell(newX, newY));
                        grid[newX][newY] = 2;
                    }

                }
                size--;
            }
        }
            return -1;
    }
       
}


