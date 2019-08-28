package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time: O(n) For every node, we check 4 near-by elements.
 * Space: O(n) For queue
 * Leetcode accepted: yes
 * Problems faced: NA
 */
public class RottingOranges {

	public static void main(String[] args) {
		int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
		System.out.println(orangesRotting(grid));
	}

	private static int orangesRotting(int[][] grid) {
		int fresh = 0, min = 0;
		Queue<int[]> q = new LinkedList<>();
		//Add the positions of rotten oranges to queue and find count of fresh oranges
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == 1) {
					fresh++;
				}
				if(grid[i][j] == 2) {
					q.add(new int[]{i, j});
				}
			}
		}
		if(fresh == 0) return min;
		while(!q.isEmpty()) {
			int size = q.size();
			while(size > 0) {
				int[] temp = q.remove();
				int row = temp[0];
				int col = temp[1];
				//top
				if(row > 0 && grid[row-1][col] == 1) {
					grid[row-1][col] = 2;
					fresh--;
					q.add(new int[] {row-1, col});
				}
				//bottom
				if(row < grid.length-1 && grid[row+1][col] == 1) {
					grid[row+1][col] = 2;
					fresh--;
					q.add(new int[] {row+1, col});
				}
				//right
				if(col < grid[0].length-1 && grid[row][col+1] == 1) {
					grid[row][col+1] = 2;
					fresh--;
					q.add(new int[] {row, col+1});
				}
				//left
				if(col > 0 && grid[row][col-1] == 1) {
					grid[row][col-1] = 2;
					fresh--;
					q.add(new int[] {row, col-1});
				}
				size--;
			}
			min++; //Increment minutes for every level
		}
		if(fresh != 0) return -1;
		return min-1;
	}

}
