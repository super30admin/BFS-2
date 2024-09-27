//TC - O(m*n)
//SC - O(m*n)
// Did this code successfully run on Leetcode : Yes successfully ran
// Any problem you faced while coding this : No



import java.util.*;

public class RottenOranges {

	
	private int orangesRotting(int[][] grid) {
        int time = 0;
        if(grid == null || grid.length ==0 ) return 0;
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<int []> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(grid[i][j] == 1) fresh++;
        		if(grid[i][j] == 2) q.add(new int[] {i, j}); 	
        	}
        }
        
        int[][] dirs = {{0,-1},{-1,0},{1,0},{0,1}};
        while(!q.isEmpty()) {
        	int size = q.size();
        	for(int i=0; i< size; i++) {
        		int[] curr = q.poll();
        		for(int[] dir: dirs) {
        			int r = dir[0] + curr[0];
        			int c = dir[1] + curr[1];
        			if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==1) {
        				fresh--;
        				grid[r][c] = 2;
        				q.add(new int[] {r,c});
        			}
        		}
        	}
        	time++;
        	
        }
        
        if(fresh > 0) return -1;
        return time>0 ? time-1 : 0;
        
        
		
		
    }
	public static void main(String[] args) {
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		
		RottenOranges r = new RottenOranges();
		int res = r.orangesRotting(grid);
		System.out.println(res);

	}

}
