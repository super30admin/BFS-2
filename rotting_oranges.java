/**
 * BFS: Time: O(m*n) grid roe and column
 *      Space: O(m*n)
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length ==0)return 0;
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2) queue.offer(new int[]{i,j});
            }
        }
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!queue.isEmpty()){
            int size = queue.size();
            time++;
            while(size>0){
                int[] item = queue.poll();
                for(int[] dir:dirs){
                    int r = item[0]+dir[0];
                    int c = item[1]+dir[1];
                    if(r>=0 && c>=0 && r<grid.length && c < grid[0].length && grid[r][c] == 1)
                    {    grid[r][c] = 2;
                        queue.offer(new int[]{r,c});
                    }
                }
                size--;
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1) return -1;
            }
        }

        return time>0 ? time-1 : 0;
    }
}