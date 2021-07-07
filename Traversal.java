import java.util.*;

public class Traversal {
    public static void main(String[] args) {

        /**
         * create tree
         * 
         *           1 
         *        /    \ 
         *       2      3 
         *      / \    / 
         *     4   5  6 
         *           / 
         *          7
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.right.left = new TreeNode(6);

        /**
         * create graph
         * 
         * 1 -----> 3 
         * |        ^ 
         * |        | 
         * v        | 
         * 2 -----> 4 ---> 5
         */
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            graph.put(i, new LinkedList<>());
        }
        List adjList = graph.get(1);
        adjList.add(2);
        adjList.add(3);
        adjList = graph.get(2);
        adjList.add(4);
        adjList = graph.get(4);
        adjList.add(3);
        adjList.add(5);

        // dfs tree
        System.out.print("DFS Tree: ");
        dfs(root);
        System.out.println();

        // bfs tree
        System.out.print("BFS Tree: ");
        bfs(root);
        System.out.println();

        // dfs graph
        System.out.print("DFS Graph: ");
        dfs(graph);
        System.out.println();

        // bfs graph
        System.out.print("BFS Graph: ");
        bfs(graph);
        System.out.println();

    }

    private static void dfs(TreeNode u) {
        if (u == null) {
            return;
        }
        System.out.print(u.val + " ");
        dfs(u.left);
        dfs(u.right);
    }

    private static void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode u = q.remove();
            System.out.print(u.val + " ");
            if (u.left != null) {
                q.add(u.left);
            }
            if (u.right != null) {
                q.add(u.right);
            }
        }
    }

    private static void dfs(Map<Integer, List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size() + 1];
        for (int u = 1; u <= graph.size(); u++) {
            if (!visited[u]) {
                dfsVisit(graph, u, visited);
            }
        }
    }

    private static void dfsVisit(Map<Integer, List<Integer>> graph, int u, boolean[] visited) {
        visited[u] = true;
        System.out.print(u + " ");
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                dfsVisit(graph, v, visited);
            }
        }
    }

    private static void bfs(Map<Integer, List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size() + 1];
        int src = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int u = q.remove();
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            System.out.print(u + " ");
            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    q.add(v);
                }
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}