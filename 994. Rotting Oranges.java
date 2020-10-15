class Solution {// Time and space of O(nm)
    public int orangesRotting(int[][] grid) {
        //base case
        if(grid == null)
            return 0;
        int nrow= grid.length ;
        int ncol = grid[0].length ;
        int size = 0;
        // direction array for trackig index
        int[][] dirs ={{1,0},{0,1},{-1,0},{0,-1}};
        int freshOranges = 0;
        
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        // find all rotton oranges and add that to the queue
        for(int i = 0 ; i<nrow ; i++){
            for(int j =0 ; j< ncol ; j++){
                if(grid[i][j] == 2)
                    queue.add(new Pair(i,j));
                else if(grid[i][j] == 1)
                    freshOranges += 1;     
            }
        }
        if(freshOranges == 0) return 0;
        int time = -1;
        while(!queue.isEmpty()){
            size = queue.size();
            for(int i = 0; i<size ; i++){
                Pair<Integer,Integer> cell = queue.poll();
                int row = cell.getKey();
                int col = cell.getValue();
              for(int[] dir:dirs){
                int x = row + dir[0];
                int y = col + dir[1];
                if(isValid(x,y,grid)){
                    grid[x][y] = 2;
                    freshOranges-- ;
                    queue.add(new Pair(x,y));
                } 
               }
            }
            time +=1;
        }
        return freshOranges ==0? time : -1 ;
    }
    private boolean isValid(int x, int y, int[][] grid){
       int nrow= grid.length ;
       int ncol = grid[0].length ; 
       if(x>=0 && x<nrow && y>=0 && y<ncol && grid[x][y] == 1)
           return true;
       return false;
    }
}