import java.util.LinkedList;
import java.util.Queue;
/*
 * Time Complexity of the algorithm is O(V) where v is no. of vertices.
 * space Complexity will O(v)  where v is no. of vertices.
 */

public class RottingOranges {

	public int orangesRotting(int[][] grid) {

		if (grid == null || grid.length == 0)
			return 0;

		int fresh = 0, m = grid.length, n = grid[0].length, time = 0;

		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (grid[i][j] == 2) {
					q.add(new int[] { i, j });
				} else if (grid[i][j] == 1) {
					fresh++;
				}

			}
		}

		if (fresh == 0)
			return 0;

		int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

		while (!q.isEmpty()) {

			int size = q.size();

			for (int i = 0; i < size; i++) {

				int[] curr = q.poll();

				for (int[] dir : dirs) {
					int r = dir[0] + curr[0];
					int c = dir[1] + curr[1];

					if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
						q.add(new int[] { r, c });
						grid[r][c] = 2;
						fresh--;
					}

				}

			}

			time++;
		}

		if (fresh != 0)
			return -1;

		return time - 1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
