class RottenOranges {
    
    //  Time Complexity:    O(m*n)     --> m*n (grid) nodes visited
    //  Space Complexity:   O(N)       --> queue
    
    public int orangesRotting(int[][] grid) {
         if(grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;
        
        //To add rotten oranges to queue, as a point to start traversing
        Queue<int[]> queue = new LinkedList<>(); 
        int freshOnes = 0;  // to keep track of total fresh Oranges
        
        // Counting the fresh and adding rotten oranges to queue
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    freshOnes += 1;
                if(grid[i][j] == 2)
                    queue.add(new int[]{i,j});
            }
        }
        // [[0]] --> 0 minutes
        // [[1]] --> should return -1 for impossible case (No 2)
        if(queue.isEmpty() && freshOnes == 0)
            return 0;
        
        int[][] directions = {{1,0}, {-1,0}, {0,1},{0,-1}};
        int size;
        int r, c;
        int minutes = 0;
        
        while(!queue.isEmpty()){
            size = queue.size();
            for(int i = 0; i < size; i++){
                int[] rotten = queue.poll();
                for(int[] dir : directions){
                    r = rotten[0] + dir[0];
                    c = rotten[1] + dir[1];
                    if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length &&  grid[r][c] == 1){
                        queue.add(new int[]{r,c});
                        freshOnes -= 1;
                        grid[r][c] = 2;
                    }
                }
            }
            minutes += 1;
        }
        
        if(freshOnes > 0)
            return -1;
        
        // -1 because for the last orange there wont be oranges left 
        // but the last orange gets added to queue and then queue is 
        // traversed adding extra 1 minute.
        return minutes -1;      
    }
}