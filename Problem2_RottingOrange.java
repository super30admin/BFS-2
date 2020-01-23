class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int fresh = 0;
        //base case
        //if row or col is absent
        if(grid.length == 0 || grid[0].length == 0){
            return minutes;
        }
        //creating Queue to perform Breadth first search
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                //if value is rotten; add to que
                if(grid[i][j]==2){
                    que.add(new int[]{i,j});
                }
                //if value is fresh; increment fresh
                if(grid[i][j]==1)
                    fresh++;
            }
        }
        //if no fresh; return 0 -> since no fresh to rot
        if(fresh == 0)
            return 0;
        //direction array to check adjacent nodes if are rotten or fresh
        int directions[][] = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        
        while(!que.isEmpty()){
            int size = que.size();
            //poll the que till que is not empty and size is less
            for(int k=0; k<size; k++){
                int[] curr = que.poll();
                //look up to direction array to check adjacent nodes and its value (rotten or fresh)
                for(int[] dir : directions){
                    int i = curr[0] + dir[0]; //same row
                    int j = curr[1] + dir[1]; //same column
                    if(i>=0 && j>=0 && i<grid.length && j< grid[0].length && grid[i][j]==1){
                        //if is still fresh
                        //add to que, convert to rotten
                        que.add(new int[]{i,j});
                        grid[i][j]=2;
                        //decrement fresh
                        fresh--;
                    }
                    
                }
            }
            minutes++;
        }
        
        if(fresh != 0)
            return -1;
        
        return minutes > 0 ? minutes-1 : 0;           
    }
}