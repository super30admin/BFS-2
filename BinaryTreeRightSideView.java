class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        // List<Integer> result = new ArrayList<>();

        // Queue<TreeNode> q = new LinkedList<>();
        // q.add(root);

        // while(!q.isEmpty()) {
        //     int size = q.size();
        //     System.out.println(size);
        //     for(int i = 0; i < size; i++) {
        //         TreeNode curr = q.poll();
        //         if(i == size - 1) {
        //             result.add(curr.val);
        //         }
        //         if(curr.left != null) {
        //             q.add(curr.left);
        //         }
        //         if(curr.right != null) {
        //             q.add(curr.right);
        //         }
        //     }
        // }

        // return result;

        // DFS solution
        
        dfs(root, 0);
        return result;
    }

    private void dfs(TreeNode root, int depth) {
        if(root == null) {
            return;
        }
        if(result.size() <= depth) {
            result.add(root.val);
        }
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }
}
