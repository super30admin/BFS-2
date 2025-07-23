//Time Complexity: O(n) — each node is visited once in the level-order traversal.
//Space Complexity: O(n) — for storing nodes and their parents in queues.

//Use level-order (BFS) traversal while tracking each node’s parent.
//If both target nodes are found at the same level with different parents, return true.
//If only one is found at a level or they share the same parent, return false.

class Solution {
    public boolean isCousins(TreeNode root, int value1, int value2) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<TreeNode> parentQueue = new LinkedList<>();

        nodeQueue.add(root);
        parentQueue.add(null);

        boolean value1Found = false, value2Found = false;
        TreeNode value1Parent = null, value2Parent = null;

        while (!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = nodeQueue.poll();
                TreeNode currentParent = parentQueue.poll();

                if (currentNode.val == value1) {
                    value1Found = true;
                    value1Parent = currentParent;
                }

                if (currentNode.val == value2) {
                    value2Found = true;
                    value2Parent = currentParent;
                }

                if (currentNode.left != null) {
                    nodeQueue.add(currentNode.left);
                    parentQueue.add(currentNode);
                }

                if (currentNode.right != null) {
                    nodeQueue.add(currentNode.right);
                    parentQueue.add(currentNode);
                }
            }

            if (value1Found && value2Found) return value1Parent != value2Parent;
            if (value1Found || value2Found) return false;
        }

        return false;
    }
}
