/*
Successfully run on LeetCode: Yes
Time Complexity: O(m*n)
Space Complexity: O(m*n)
1. Approach: Breadth-First Search 

*/

class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        if(grid == null || m==0)
            return 0;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2)
                    queue.add(new int[] {i,j});
                if(grid[i][j] == 1)
                    fresh++;
            }
        }

        if(fresh == 0)
            return 0;

        int minutes = 0;
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while(!queue.isEmpty()){
            int size = queue.size();

            for(int k=0; k<size; k++){
                int[] cur = queue.poll();
                for(int[] dir: dirs){
                    int i = dir[0] + cur[0];
                    int j = dir[1] + cur[1];

                    if(i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1){
                        grid[i][j] = 2;
                        queue.add(new int[]{i, j});
                        fresh--;
                    }
                }
            }
            minutes++;
        }

        if(fresh != 0){
			return -1;
		}
            
        return minutes > 0 ? minutes - 1 : 0;
    }
} 