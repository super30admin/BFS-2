// Time Complexity : O(m*n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * start with all rotten oranges, maintain size var in queue to calculate time, increase time if queue has elements left
 * for processing, mark fresh orage to -1 before adding to queue to make sure we do not add it again in the next pass to queue
 * 
 * https://leetcode.com/problems/rotting-oranges/
 *
 */
public class RottenOranges {
	public int orangesRotting(int[][] grid) {
		int min = 0;
		Queue<int[]> q = new LinkedList<>();
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

		//add all rotten oranges location to queue
		for(int i=0; i<grid.length;i++) {
			for(int j=0; j<grid[0].length;j++){
				if(grid[i][j] == 2){
					q.add(new int[]{i,j});
				}
			}
		} 

		while(!q.isEmpty()) {
			//size of current queue to calculate minutes
			int size = q.size();

			while(size > 0) {
				int[] loc = q.poll();
				size--;

				//make current location rottem
				grid[loc[0]][loc[1]] = 2;

				//use dir array to get 4 neighbours
				for(int k=0; k<dir.length; k++) {
					int row = dir[k][0] + loc[0];
					int col = dir[k][1] + loc[1];

					//if range check and neighbour is fresh
					if(row >=0 && 
							row < grid.length && 
							col >=0 && 
							col < grid[0].length && 
							grid[row][col] == 1) {
						//change it to -1 so we do not add it again to the queue for the next pass
						//then add to the queue
						grid[row][col] = -1;  
						q.add(new int[] {row, col});
					}
				}
			}

			//if we still have fresh elements, we need more time, increase min
			if(!q.isEmpty()){
				min++;
			}
		}

		for(int i=0; i<grid.length;i++) {
			for(int j=0; j<grid[0].length;j++){
				if(grid[i][j] == 1) {
					return -1;
				}
			}
		}

		return min;
	}
}
