// Time Complexity : O(mn)
// Space Complexity : O(mn) worst case, in cases where most are rotten oranges and we add them to the queue 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : initializing minutes passed to -1/0, at first initialized it to 0 but then there were cases where 
// the queue still had elements when already the #freshOranges were 0, was doing 1 extra pass

// Your code here along with comments explaining your approach
// process grid to get #fresh oranges
// put all rotten oranges, (r,c) in queue
// pop() elements and update neighbours
// do till queue is empty or freshOrangeCount>0

class Solution {
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    private int getFreshOrangesCount(int[][] grid){
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    
    public int orangesRotting(int[][] grid) {
        int minutesPassed = 0;
        int freshOrangesCount = getFreshOrangesCount(grid);
        
        if(freshOrangesCount==0) return 0;
        
        Queue<int[]> queue = new LinkedList<int[]>();
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i, j});
                }
            }
        }
        
        while(!queue.isEmpty() && freshOrangesCount>0){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int[] rottenOrangePosition = queue.poll();
                
                for(int[] dir : dirs){
                    int r = rottenOrangePosition[0] + dir[0];
                    int c = rottenOrangePosition[1] + dir[1];
                    
                    if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]==1){
                        grid[r][c] = 2;
                        freshOrangesCount--;
                        
                        queue.add(new int[]{r, c});
                    }
                }
            }
            
            minutesPassed++;
        }
        
        if(freshOrangesCount==0) return minutesPassed;
        else return -1;
    }
}

// Time Complexity : O(mn * (m+n)) worst case
// Space Complexity : O(mn), creating a new grid copy at each step 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : accounting for updated values in a time step, keeping track of what oranges were updated at this iteration

// Your code here along with comments explaining your approach
// this is the bruteforce approach as to how one would do it
// first get fresh oranges count
// process grid to update, copy grid, look for 2's in previous grid and update neighbours in the current grid, decrement fresh oranges count
// repeat process till either there is no change in fresh orange count in the iterations or fresh orange count reaches 0
// the time complexity of this would be O(mn)*O(m+n), O(mn) for processing the grid to look for 2's * #times processing occurs, worst case O(m+n) top row all 1's and last column all 1's 

class Solution {
    static int[][] grid;
    int passedMinutes;
    int prevFreshOrangeCount;
    int freshOrangeCount;
    int[][] dirs;
    
    
    private int getFreshOrangeCount(){
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    
    private int[][] getGridCopy(){
        int[][] gridCopy = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            gridCopy[i] = Arrays.copyOf(grid[i], grid[i].length);
         }
        return gridCopy;
    }
    
    private void updateGrid(){
        int r = 0 , c = 0;
        int[][] gridCopy = getGridCopy();  
        
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]==2){
                    for(int[] dir : dirs){
                        r = i+dir[0];
                        c = j+dir[1];
                        
                        if(r>=0 && r<grid.length && c>=0 && c<grid[0].length && grid[r][c]==1 && gridCopy[r][c]!=2){
                            gridCopy[r][c] = 2;
                            freshOrangeCount--;
                        }
                    }
                }
            }
        }
        
        passedMinutes++;
        grid = gridCopy;
    }
    
    public int orangesRotting(int[][] grid) {
        this.grid = grid;
        this.freshOrangeCount = getFreshOrangeCount();
        this.passedMinutes = 0;
        this.prevFreshOrangeCount = 0;
        this.dirs = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
        
        
        if(freshOrangeCount==0) return 0;
        
        while(freshOrangeCount!=0 && prevFreshOrangeCount!=freshOrangeCount){
            prevFreshOrangeCount = freshOrangeCount;
            updateGrid();
        }
        
            
        if(freshOrangeCount==0){
            return passedMinutes;
        }
        
        else return -1;
    }
}