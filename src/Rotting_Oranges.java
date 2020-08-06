//Time Complexity :O(n), worst case O(M * N)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/* Using BFS, we traverse through the grid and keep a count of fresh oranges left, and adding rotten oranges to the queue. 
 * process the rotten oranges by removing from the queue, in that way we will look on the 4 directions and if there are any fresh oranges, we make it rotten and add to queue.
 * If the fresh count is not zero. then we return -1 or else we return the time */

import java.util.*;

public class Rotting_Oranges {
	public int orangesRotting(int[][] grid) {
		if(grid == null || grid.length == 0)	// if no oranges, time taken will be 0
			return 0;

		Queue<int []> q = new LinkedList<>();
		int fresh = 0;	 // to keep track of fresh oranges left

		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[0].length; j++){
				if(grid[i][j] == 2)	// adding all rotten oranges to queue
					q.add(new int[] {i,j});

				if(grid[i][j] == 1)	// if fresh orange, increase fresh count
					fresh++;
			}
		}

		if(fresh == 0)	// if no fresh oranges present
			return 0;

		int[][] direction = {{0,1}, {0,-1},{1,0},{-1,0}};
		int time = 0;

		while(!q.isEmpty()){
			int size = q.size();

			for(int i=0; i<size; i++){

				int[] curr = q.poll();	// get the current orange to process

				for(int[] dir: direction){
					// to go to a neighbor in that particular direction
					int r = curr[0] + dir[0];
					int c = curr[1] + dir[1];

					// boundary check and if neighbors are fresh
					if(r >= 0 && r < grid.length &&
							c >= 0 && c < grid[0].length &&
							grid[r][c] == 1){

						grid[r][c] = 2;	// make it rotten
						fresh--;	// decrease count as processed
						q.add(new int[] {r,c});	// add to queue
					}
				}

			}
			time++;
		}
		if(fresh != 0)
			return -1;

		return time - 1;
	}
}
