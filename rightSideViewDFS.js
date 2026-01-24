/**
 * @param {TreeNode} root
 * @return {number[]}
Intuition:
To determine the right side view of a binary tree, we perform a depth-first traversal while keeping track of the current depth. 
The traversal visits the right child before the left child, ensuring that the first node encountered at each level is the rightmost one visible from that level.
 We store a value only when we reach a new level for the first time, which can be detected when the current level equals the size of the result list.
This guarantees that each level contributes exactly one value, and that value represents the node visible from the right side of the tree.
T.C: O(n)
S.C: O(h) // height of the tree
 */
var rightSideViewDFS = function (root) {
    if (!root) return [];
    const res = [];
    const dfs = (root, level = 0) => {
        // base case
        if (!root) return;

        // action
        if (res.length === level) {
            res.push(root.val);
        }
        // left sub tree
        dfs(root.right, level + 1);
        //right sub tree
        dfs(root.left, level + 1);
    }
    dfs(root);
    return res;
};