// Time Complexity :  O(M*N) size of rows and cols
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length  == 0) return 0;
        //to maintain our next iteration changes
        Queue<int []> q = new LinkedList();
        int fresh = 0;
        for(int i = 0;i< grid.length;i++){
            for(int j = 0;j< grid[0].length;j++){
                if(grid[i][j] == 2){
                    q.add(new int[] {i,j});
                }
                else if(grid[i][j] == 1) 
                    fresh++;
            }
        }
        int time = -1; // starting time should be -1 since 1st element is 
        if(fresh == 0) return 0;
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] element = q.poll();
                for(int[] dir: dirs){
                    int x = element[0] + dir[0];
                    int y = element[1] + dir[1];
                    if(x >= 0 && x < grid.length && y >=0 && y < grid[0].length && grid[x][y] == 1){
                        q.add(new int [] {x,y});
                        fresh--;
                        grid[x][y] = 2;
                    }
                }
            }
            time++;   
        }
        if(fresh > 0) return -1;
        return time;
    }
}