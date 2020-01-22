// Time Complexity :O(N^2)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {		// check for all the elements of 2 and record the corresponding indices  
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int depth = 2;
        while(!queue.isEmpty()) {
            int[] o = queue.poll();		// process the indices in the same order and the change the neighbours to 1 greater than the value starts from 3
            for(int i=0; i<dir.length; i++) {
                int x = o[0] + dir[i][0];
                int y = o[1] + dir[i][1];
                if(x>=0 && x<grid.length && y>=0 && y<grid[x].length && grid[x][y] == 1) {
                    grid[x][y] = grid[o[0]][o[1]] + 1;
                    depth = Math.max(grid[x][y], depth);
                    queue.offer(new int[]{x, y});
                }
            }
        }
        depth -= 2;
        for(int i=0; i<grid.length; i++) {		// check if the there's one left, if yes, return -1 or depth - 2
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return depth;
    }
}