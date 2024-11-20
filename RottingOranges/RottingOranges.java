package RottingOranges;

import java.util.*;

//Time Complexity - O(n^2)
//Space Complexity - O(n)

class RottingOranges {
	public int orangesRotting(int[][] grid) {
		int freshOranges = 0;
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1)
					freshOranges++;
				else if (grid[i][j] == 2)
					queue.add(new int[] { i, j });
			}
		}
		if (freshOranges == 0)
			return 0;
		int minutes = 0;
		while (!queue.isEmpty()) {
			int count = queue.size();
			for (int k = 0; k < count; k++) {
				int[] temp = queue.poll();
				int row = temp[0];
				int col = temp[1];
				// go right
				if (col < grid[0].length - 1 && grid[row][col + 1] == 1) {
					grid[row][col + 1] = 2;
					queue.add(new int[] { row, col + 1 });
					freshOranges--;
				}
				// go left
				if (col > 0 && grid[row][col - 1] == 1) {
					grid[row][col - 1] = 2;
					queue.add(new int[] { row, col - 1 });
					freshOranges--;
				}
				// go top
				if (row > 0 && grid[row - 1][col] == 1) {
					grid[row - 1][col] = 2;
					queue.add(new int[] { row - 1, col });
					freshOranges--;
				}
				// go down
				if (row < grid.length - 1 && grid[row + 1][col] == 1) {
					grid[row + 1][col] = 2;
					queue.add(new int[] { row + 1, col });
					freshOranges--;
				}
			}
			minutes++;
		}
		if (freshOranges == 0)
			return minutes - 1;
		return -1;
	}
}