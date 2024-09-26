//ROTTEN ORANGES PROBLEM, LEETCODE PBM 994 

/*Algorithm:
    - Traverse through the 2D array if rotten orange found, Add to the queue and if fresh orange increase fresh count
    - Take the rotten orrange check if in the adjacent cells there are any fresh oranges, if found decrese fresh count, mark the adjacent orange rotten and add the position to queue. After processing each level increase count by 1
    -After queue is empty, Return count-1 if fresh is 0 else return -1;
    
*/



class Solution {
    public int orangesRotting(int[][] grid) {
        
        int count=0;
        int m = grid.length; // No of rows of grid 2D array
        int n=grid[0].length; // No of columns of grid 2D array
        int fresh=0;
        
        if(m==0){
            return 0;
        }
        Queue<int[]> q = new LinkedList<>(); // To keep adding the rotten orange cell positions.
        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==2){ //If rotten Oranges are there adding it to the queue.
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1){ //If fresh oranges found increasing the number of fresh oranges.
                    fresh++;
                }
                
            }
        }
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}}; //These are to move in 4 different directions.
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int k=0;k<size;k++){
                int rottenOr[] = q.poll();//Taking out one rotten orange.
                for(int[] dir:dirs){
                    int x = dir[0] + rottenOr[0]; //Y direction to move
                    int y = dir[1]+rottenOr[1]; //X direction to move
                    if(x>=0&&y>=0&&x<m&&y<n&&grid[x][y]==1){ //Check for array bound exceptions and if the grid has a fresh orange.
                        grid[x][y]=2; // Marking the adjacent fresh oranges as rotten
                        fresh--;
                        q.add(new int[]{x,y});//Adding the adjacent oranges which are now marked rotten into the queue.
                    }
                }
                
                
            }
            count++; // After processing each cell increase the count by 1
            
        }
        
        if(fresh!=0)
            return -1;
        
        return count>0?count-1:count;
    
        
    }
}