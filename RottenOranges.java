// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
	class BFSSolution {
	    public int orangesRotting(int[][] grid) {
	        if(grid == null || grid.length == 0) return 0;
	        int m = grid.length;
	        int n = grid[0].length;
	        int fresh = 0;
	        Queue<int[]> q = new LinkedList<>();
	        for(int i = 0; i < m; i++){
	            for(int j = 0; j < n; j++){
	                if(grid[i][j] == 2) q.add(new int[]{i, j});
	                if(grid[i][j] == 1) fresh++;
	            }
	        }
	        int time = 0;
	        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	        while(!q.isEmpty()){
	            int size = q.size();
	            for(int i = 0; i < size; i++){
	                int[] rotten = q.poll();
	                for(int[] dir: dirs){
	                    int r = rotten[0] + dir[0];
	                    int c = rotten[1] + dir[1];
	                    if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1){
	                        grid[r][c] = 2;
	                        q.add(new int[]{r, c});
	                        fresh--;
	                    }
	                }
	            }
	            time++;
	        }
	        if(fresh > 0) return -1;
	        return time > 0 ? time - 1 : 0;
	    }
	}
}
