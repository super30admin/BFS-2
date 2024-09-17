// TC: O(N) since we are traversing through the grid and n is size of the grid.
// SC : O(N) which represents the size of the grid, in worst case, we are storing rotten oranges in the grid.

// We will put all the rotten oranges indices of the grid onto our queue. while processing the queue, we check loop through the size of the queue to check in all the 4 directions.
// if the any of the indices of the grid has fresh oranges, and its neighbors in 4 directions has rotten oranges, we update our the fresh oranges as rotten oranges/
 // and add those indices which had rotten oranges in the grid. Once we have completely processed the queue data and all its neighbors, we update our minimum time. 
// this way, we are keeping track of rotten oranges and updating our queue with new rotten oranges that turned out from fresh orange.
// We will check until our queue is empty, because queue empty means that we have processed all our oranges in grid.

// We will check in the end if any of the indices in the grid has value 1, this means we were not able to turn all the fresh oranges into rotten oranges, so we return -1;
// If our minimum time is 0, that means all the oranges were rotten, it not we should return time - 1.



import java.util.*;

public class rottingOranges {

	public int RotOrange(int[][] grid) {
		
		if(grid==null || grid.length==0)
			return 0;
			
		int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
		int m = grid.length, n = grid[0].length;
		int level = 0;
		Queue<int[]> queue = new LinkedList<>();
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j]==2)
					queue.offer(new int[]{i,j});
			}
		}
		
		while(!queue.isEmpty()) {
			level++;
			int size = queue.size();
			
			for(int i=0;i<size;i++) {
				
				int[] curr = queue.poll();
				for(int[] dir: dirs) {
					int newX = curr[0] + dir[0];
					int newY = curr[1] + dir[1];
					
					if(newX < 0 || newY < 0 || newX >= m || newY >= n || grid[newX][newY]!=1)
						continue;
					grid[newX][newY] = 2;
					queue.offer(new int[] {newX, newY});
				}
			}
		}
		
		for(int[] x: grid) {
			for(int y: x) {
				if(y==1)
					return -1;
			}
		}
		return level==0?0:level-1;
		
	}
	
	public static void main(String[] args) {
		
		rottingOranges ro = new rottingOranges();
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		System.out.println(ro.RotOrange(grid));
	}
}
