class RottingOranges {
    // Approach 1 - Using BFS
    // Time complexity - O(n)
    // Space complexity - O(n)
    // Tested in leetcode
    
    // This function uses queue to store the indexs of fresh oranges next to a roten oranges.
    // total number of level of BFS iteration is returned.
     public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
         int fresh = 0;
         // iterate over the metrix to find out the indexes of rotten oranges and count fresh oranges
        for(int i=0; i<row;i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
                if(grid[i][j] == 1)
                    fresh++;
                
            }
        }
         // stores the total type of allowed movement while for BFS traversal
        int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
        int count = 0;
         
        // iterate till queue is empty
        while(!queue.isEmpty()){
            int size = queue.size();
            
            // for every level iterate upto the size of the level
            while(size-- >0){
                int[] temp = queue.poll();
                for(int[] dir : direction){
                    int i = temp[0] + dir[0];
                    int j = temp[1] + dir[1];
                    
                    // to avoid indexOut of bound error and mark fresh oranges as rotten
                    if( i >= 0 && i < row && j >=0 && j< col && grid[i][j] == 1){
                        queue.add(new int[]{i,j});
                        grid[i][j] = 2;
                        fresh--;
                    }
                }
            }
            count++;
        }
        // return -1 if there some of the fresh oranges cant be make rotten
        if(fresh != 0)
             return -1;
         
        return count>0 ? count -1 : count;
    }
}