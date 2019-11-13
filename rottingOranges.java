/* 994. Rotting Oranges
Time Complexity: O(m*n)
Space Complexity: O(m*n)

Breadth-First Search 
Push all the co-ordinates of the rotten oranges into the queue. As and when we finish a level, do minutes+1, decrease the fresh count and increase the minutes for every level.

return -1 if all fresh oranges cannot be rotten
return 0 if there are no fresh oranges

there is atleast one rotten orange for the process to continue
increase the number of minutes after each level
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        if(grid == null || m==0)
            return 0;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2)
                    q.add(new int[] {i,j});
                if(grid[i][j] == 1)
                    fresh++;
            }
        }

        if(fresh == 0)
            return 0;

        int minutes = 0;
        //left, right, top, bottom
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while(!q.isEmpty()){
            int size = q.size();

            for(int k=0; k<size; k++){
                int[] cur = q.poll();
                for(int[] dir: dirs){
                    int i = dir[0] + cur[0];
                    int j = dir[1] + cur[1];

                    if(i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1){
                        grid[i][j] = 2;
                        q.add(new int[]{i, j});
                        fresh--;
                    }
                }
            }
            minutes++;
        }

        if(fresh != 0)
            return -1;

        // return minutes-1;
        return minutes > 0 ? minutes - 1 : 0;
    }
}