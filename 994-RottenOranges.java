/**LC- 994
 * Time Complexity : O(M*N) 
 * Space Complexity : O(M*N)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : Yes
I did not keep track of the fresh oranges. this lead to two problems:
    1. it failed the cases where there were no fresh or rotten oranges. If we keep track of it, we can return 0 if fresh == 0
    2. We keep decreasing the fresh count when it becomes rotten. Thus, just a variable check is need at last to check if any fresh oranges are left/
    We don't have to again reiterate the whole matrix to see if 1 is present.

    Test case failed: [[0]] for such scenario.
 *
 Algorithm:
 1. We first iterate the whole matrix- we count fresh oranges and add all rotten oranges in the queue.
 2. At each level traversal, we increase the time. To keep track of the level, I used the size variable.
 3. we process the queue till it is empty..maintain size variable
 4. we poll the element, check it's 4 dirs. If we find 1 we convert it to 2 and decrease fresh--. 
 */

class Solution {
    public int orangesRotting(int[][] grid) {
        
        if(grid == null || grid.length == 0) return 0;
        
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < grid.length; i++){
            
            for(int j = 0; j< grid[0].length; j++){
                
                if(grid[i][j] == 1) fresh++;
                if(grid[i][j] == 2) q.add(new int[]{i, j});
                
            }
        }
        if(fresh == 0) return 0;
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int time = 0;
        while(!q.isEmpty()){
            
            int size = q.size();
            for(int i = 0; i < size; i++){
                
                int[] curr = q.poll();
                for(int[] dir: dirs){
                    
                    int r = dir[0] + curr[0];
                    int c = dir[1] + curr[1];
                    if(r >=0 && r<grid.length && c >= 0 && c<grid[0].length && grid[r][c] == 1){
                        
                        q.add(new int[]{r, c});
                        grid[r][c] = 2;
                        fresh--;
                    }
                }
            }
            time++;
        }
        if(fresh > 0) return -1;
        return time - 1;
    }
}