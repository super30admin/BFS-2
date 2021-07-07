/**
 * Given an undirected graph, return true if and only if it is bipartite.
 * 
 * Recall that a graph is bipartite if we can split it's set of nodes into two
 * independent subsets A and B such that every edge in the graph has one node in
 * A and another node in B.
 * 
 * The graph is given in the following form: graph[i] is a list of indexes j for
 * which the edge between nodes i and j exists. Each node is an integer between
 * 0 and graph.length - 1. There are no self edges or parallel edges: graph[i]
 * does not contain i, and it doesn't contain any element twice.
 * 
 * Idea:
 * Use dfs algorithm, with coloring, bipartite graphs are 2 colorable, if we detect conflict 
 * we report that graph is not bipartite, true otherwise.
 * 
 * Time Complexity: O(V+E) 
 * Space Complexity: O(V+E)
 * 
 * Leetcode Result: Runtime: 0 ms, faster than 100.00% of Java online submissions for Is Graph Bipartite?. 
 * Memory Usage: 44.1 MB, less than 63.42% of Java online submissions for Is Graph Bipartite?.
 */
class Bipartite {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) { // call dfsVisit for unvisited nodes
            if (!visited[i]) {
                color[i] = 0;
                boolean flag = dfsVisit(graph, i, visited, color);
                if (flag == false) { // conflict?
                    return false;
                }
            }
        }
        // all well
        return true;
    }

    private boolean dfsVisit(int[][] graph, int u, boolean[] visited, int[] color) {
        visited[u] = true; // mark visited
        for (int v : graph[u]) {
            if (visited[v]) {
                if (color[v] == color[u]) { // conflict??
                    return false;
                }
            }
            if (!visited[v]) { 
                color[v] = 1 - color[u]; // color v
                boolean flag = dfsVisit(graph, v, visited, color);
                if (flag == false) { // conflict??
                    return false;
                }
            }
        }
        return true;
    }
}