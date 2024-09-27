// Time Complexity : O(N) - As we iterate through the whole grid
// Space Complexity : O(N) - AS We use a Queue data structure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int freshoranges = 0;
        int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i,j));
                }
                else if(grid[i][j] == 1){
                    freshoranges += 1;
                }
            }
        }
        if(freshoranges == 0) return 0;
        int time = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size;i++){
            Pair<Integer,Integer> cell = queue.poll();
            int row = cell.getKey();
            int col = cell.getValue();
            for(int[] dir : dirs){
                int x = row + dir[0];
                int y = col + dir[1];
                if(isValid(x,y,grid)){
                    grid[x][y] = 2;
                    freshoranges--;
                    queue.add(new Pair(x,y));
                }
            }
           }
            time += 1;
        }
        
        return freshoranges == 0? time - 1 : -1;
        
    }
    public boolean isValid(int x,int y,int[][] grid){
        int rows = grid.length;
        int cols = grid[0].length;
        if(x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1)
              return true;
    
        return false;
    }
}
// Your code here along with comments explaining your approach