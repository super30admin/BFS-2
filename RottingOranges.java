// Time Complexity : O(N*M) N = number of rows, M = number of columns
// Space Complexity : O(N*M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int orangesRotting(int[][] grid) {
        
        if(grid == null || grid.length == 0)    return 0;
        
        int freshO = 0;
        int minutes = -1;
        Queue<Pair<Integer,Integer>> queue = new LinkedList();
        
        //count fresh oranges
        for(int i = 0;i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) freshO++;
                if(grid[i][j] == 2) queue.add(new Pair<>(i,j));
            }
        }
        
        if(freshO == 0) return 0;
        
        //directions
        int dirs[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            minutes++;
            
            for(int i = 0;i < size; i++){
                Pair<Integer, Integer> p = queue.remove();
                
                for(int dir[]: dirs){
                    int x = dir[0] + p.getKey();
                    int y = dir[1] + p.getValue();
                    
                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length){
                        if(grid[x][y] == 1){
                            grid[x][y] = 2;
                            freshO--;
                            queue.offer(new Pair<>(x,y));
                        }
                    }
                    
                }
            }
            
        }
        
        return freshO == 0? minutes : -1;
    }
}
