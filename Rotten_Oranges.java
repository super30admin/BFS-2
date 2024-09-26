
// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

class Rotten_Oranges {

	public int orangesRotting(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int fresh = 0;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1)
					fresh++;
				if (grid[i][j] == 2)
					q.add(new int[] { i, j });
			}
		}
		if (fresh == 0)
			return 0;
		int minutes = 0;
		int directions[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int curr[] = q.poll();
				for (int dir[] : directions) {
					int r = curr[0] + dir[0];
					int c = curr[1] + dir[1];

					if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
						grid[r][c] = 2;
						fresh--;
						q.add(new int[] { r, c });
					}
				}
			}
			minutes++;
		}
		if (fresh > 0)
			return -1;
		return --minutes;
	}
}