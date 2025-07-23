//Time Complexity: O(n) — each node is visited once during the DFS traversal.
//Space Complexity: O(h) — due to recursion stack, where h is the height of the tree.

//Perform DFS prioritizing the right child before the left.
//At each level, add the first node you encounter to the result list.
//Recursively visit right and left children while tracking the current depth.

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> visibleNodes = new ArrayList<>();
        if (root == null) return visibleNodes;

        collectRightView(root, visibleNodes, 0);
        return visibleNodes;
    }

    private void collectRightView(TreeNode currentNode, List<Integer> visibleNodes, int currentLevel) {
        // Base case
        if (currentNode == null) return;

        // If we're visiting this level for the first time, add the node's value
        if (visibleNodes.size() == currentLevel) {
            visibleNodes.add(currentNode.val);
        }

        // Visit right first, then left
        collectRightView(currentNode.right, visibleNodes, currentLevel + 1);
        collectRightView(currentNode.left, visibleNodes, currentLevel + 1);
    }
}
