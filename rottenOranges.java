// Time Complexity : o(mxn)
// Space Complexity : o(mxn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 994
//Approach : BFS

//If DFS, 
// Time Complexity : o(mxn)^2
// Space Complexity : o(mxn)



class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int []> q = new LinkedList<>();
        //base
        if(grid == null || grid.length == 0 ) return 0;
        
        int m = grid.length;
        int n = grid[0].length;
        int time = 0;
        int fresh= 0;
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if (grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2) q.add(new int[] {i,j});
            }
        }
        
        //return 0 if there is no fersh orange
        if(fresh == 0) return 0;
        int[][] dirs = { {0,1} , {0,-1} , {-1,0}, {1,0}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i <size; i++){
                int[] curr = q.poll();
                for(int[] dir : dirs){
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if(r >= 0 && r<m && c>=0 && c<n && grid[r][c] == 1){
                        
                        q.add(new int[] {r,c});
                        fresh--;
                        grid[r][c] = 2;
                    }
                }
            }
            //add 1 after every iteration
            time++;
        }
        //if all are not rotten, return -1
        if(fresh > 0 ){
            return -1;
        }
        
        //we are one step ahead so we need to return time-1
        return time-1;
        
    }
}