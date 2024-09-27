class RottenOranges{
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length == 0) return 0;
        int freshcount = 0;
        int size;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    freshcount++;
                }else if(grid[i][j]==2){
                    q.add(new int[]{i,j});
                }
            }
        }

        if(freshcount == 0){
            return 0;
        }
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int result=0;
        while(!q.isEmpty()){
            size = q.size();
            result++;
            for(int i=0;i<size;i++){
                int[] curr = q.poll();
                for(int[] d : dir){
                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];

                    if(r>=0 && c>=0 && r<grid.length &&c<grid[0].length && grid[r][c] == 1){
                        grid[r][c]=2;
                        freshcount--;
                        q.add(new int[]{r,c});
                    }
                }

            }
        }

        if(freshcount==0){
            return result-1;
        }

        return -1;
    }
    //Time complexity: o(mXn)
    //space complexity : o(n)
    //start from rotten oranges and DO BFS.and check if there are any fresh oranges after bfs and return number of iterations done.
}