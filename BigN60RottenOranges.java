//Time complexity is O(m*n) i.e row*column.
//Space complexity is O(m*n) i.e row*column elements in queue.
//This solution is submitted on leetcode

import java.util.LinkedList;
import java.util.Queue;

public class BigN60RottenOranges {
	public int orangesRotting(int[][] grid) {
		int row = grid.length;
		int column = grid[0].length;
		// edge case
		if (row == 0 || grid == null)
			return 0;
		// no need to add new keyword in <> for any data type
		Queue<int[]> q = new LinkedList<>();
		int time = 0;
		int fresh = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (grid[i][j] == 2)
					q.add(new int[] { i, j });
				if (grid[i][j] == 1)
					fresh++;
			}
		}
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] temp = q.poll();
				for (int[] dir : dirs) {
					int r = temp[0] + dir[0];
					int c = temp[1] + dir[1];
					if (r >= 0 && c >= 0 && r < row && c < column && grid[r][c] == 1) {
						grid[r][c] = 2;
						q.add(new int[] { r, c });
						fresh--;
					}
				}
			}
			time++;
		}
		if (fresh > 0)
			return -1;
		if (time > 0)
			return time - 1;
		else
			return 0;
	}
}