import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
	public int orangesRotting(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		int freshOranges = 0;
		Queue<int[]> q = new LinkedList<>();

		int row = grid.length;
		int col = grid[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					freshOranges++;
				}
				if (grid[i][j] == 2)
					q.add(new int[] { i, j });

			}
		}

		if (freshOranges == 0)
			return 0;
		int timer = 0;
		int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();
				for (int[] dir : dirs) {
					int r = arr[0] + dir[0];
					int c = arr[1] + dir[1];

					if (r >= 0 && r < row && c >= 0 && c < col && grid[r][c] == 1) {
						freshOranges--;

						q.add(new int[] { r, c });
						grid[r][c] = 2;
					}

				}

			}

			timer++;

		}
		if (freshOranges > 0)
			return -1;

		return timer - 1;

	}
}
