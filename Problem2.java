// Time Complexity : O(2mn)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach: using bfs approach

class Solution {
    public int orangesRotting(int[][] grid) {
        //Base case
        if(grid == null) return 0;
        
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int[][] drs = {{1,0},{0,1},{-1,0},{0,-1}};
        int size = 0, frOrg = 0;
        int t = -1;
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 2) {
                    queue.add(new Pair(i,j));
                }
                else if(grid[i][j] == 1) frOrg++;
            }
        }
        if(frOrg == 0) return 0;
        
        while(!queue.isEmpty()){
            size = queue.size();
            for(int i = 0; i < size; i++){
                Pair<Integer,Integer> cell = queue.poll();
                int nrow = cell.getKey();
                int ncol = cell.getValue();
                
                for(int[] dir: drs){
                    int x = nrow + dir[0];
                    int y = ncol + dir[1];
                    if(isValid(x,y,grid)){
                        grid[x][y] = 2;
                        frOrg--;
                        queue.add(new Pair(x,y)); 
                    }
                }
                
            }
            t++;
        }
        
        return frOrg == 0? t : -1;
    }
    
    private boolean isValid(int x, int y, int[][] grid){
        int nrow = grid.length;
        int ncol = grid[0].length;
        if(x >= 0 && x < nrow && y >= 0 && y < ncol && grid[x][y] == 1 ){
            return true;
        }
        return false;
    }
}
