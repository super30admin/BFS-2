package bfs2;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;


// Leetcode 74/78 test cases passed
// Failing in case of disconnected graph - [[],[2,4,6],[1,4,8,9],[7,8],[1,2,8,9],[6,9],[1,5,7,8,9],[3,6,9],[2,3,4,6,9],[2,4,5,6,7,8]]
// Time Complexity  = O (N * N)
// Space Complexity = O (N)
//

public class Bipartite {
	// visit each node and put its neighbors into a or b
	// put its neighbors into que and mark visited
	// nodes should be different in two independent sets
	// if any one of the common nodes found then not bipartiate

	public boolean isBipartite(int[][] graph) {

		// Initialize visited array to 0
		int[] visited = new int[graph.length];
		for (int i = 0; i < visited.length; i++)
			visited[i] = 0;

		// create two sets a & b
		Set<Integer> A = new HashSet<Integer>();
		Set<Integer> B = new HashSet<Integer>();

		boolean aorb = true; // true = A, false = B
		// start visiting each node and put neighbours into eith A or B
		Queue<Integer> que = new ArrayDeque<Integer>();
		que.add(0);

		while (!que.isEmpty()) {
			int qsize = que.size();

			for (int i = 0; i < qsize; i++) {
				Integer current = que.poll();

				if (aorb && visited[current] != 1) {
					if (B.contains(current))
						return false;

					for (int j = 0; j < graph[current].length; j++) {
						B.add(graph[current][j]);
						que.offer(graph[current][j]);
					}

				}
				if (!aorb && visited[current] != 1) {
					if (A.contains(current))
						return false;

					for (int j = 0; j < graph[current].length; j++) {

						A.add(graph[current][j]);
						que.offer(graph[current][j]);
					}
				}
				visited[current] = 1;
			}
			aorb = !aorb;
		}
		return true;
	}
}
