package bfs2;

import java.util.ArrayDeque;
import java.util.Queue;


// Time Complexity =  O(rows * columns ) =  O(n)
// Time complexity = O(n)
public class RottenOranges {
	// parse all cells and store rotten oranges at start in the queue
	// for each rotten orange
	// 1. pop from queue
	// 2. mark its adjacent oranges as rotten and add into queue if not already rotten
	// 3. repeat until queue empty
	// If all oranges are rotten then answer will be the number of iterations
	// otherwise -1

	class location {
		int x = 0;
		int y = 0;

		public location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public int orangesRotting(int[][] grid) {

		// Initialize the que for storing rotten oranges
		Queue<location> que = new ArrayDeque<location>();
		int iterations = -1; // because to start from minute 0
		int fresh = 0; // to check if there are any fresh oranges to start with
		// find all the rotten oranges at start
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 2)
					que.offer(new location(i, j));

				// code was failing for case [[0]], hence added below check
				// suggest better way if any.
				if (grid[i][j] == 1)
					fresh++;

			}

		if (fresh == 0)
			return 0;

		while (!que.isEmpty()) {

			int qsize = que.size();
			iterations++;
			for (int qz = 0; qz < qsize; qz++) {
				location l = que.poll();
				// check for adjacent oranges

				// Check for upper orange
				if (l.x - 1 >= 0 && grid[l.x - 1][l.y] == 1) {
					que.offer(new location(l.x - 1, l.y));
					grid[l.x - 1][l.y] = 2;
				}
				// check for lower orange
				if (l.x + 1 < grid.length && grid[l.x + 1][l.y] == 1) {
					que.offer(new location(l.x + 1, l.y));
					grid[l.x + 1][l.y] = 2;
				}
				// check for left orange
				if (l.y - 1 >= 0 && grid[l.x][l.y - 1] == 1) {
					que.offer(new location(l.x, l.y - 1));
					grid[l.x][l.y - 1] = 2;
				}
				// check for right orange
				if (l.y + 1 < grid[0].length && grid[l.x][l.y + 1] == 1) {
					que.offer(new location(l.x, l.y + 1));
					grid[l.x][l.y + 1] = 2;
				}

			}

		}
		// check if any orange is fresh
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1)
					return -1;

			}

		return iterations;
	}
}