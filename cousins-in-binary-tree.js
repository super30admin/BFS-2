// Time Complexity : O(N) For BFS and DFS
// Space Complexity : O(N) for BFS and O(H) for DFS
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @param {number} x
 * @param {number} y
 * @return {boolean}
 */
// BFS
// var isCousins = function(root, x, y) {
//     if (root == null) return false;
    
//     let queue = [root];
//     while (queue.length) {
//         let size = queue.length,
//             xFound = false,
//             yFound = false;

//         for (let i = 0; i < size; i++) {
//             let node = queue.shift();
//             if (node.val == x) xFound = true;
//             if (node.val == y) yFound = true;
//             if (node.left && node.right) {
//                 if (node.left.val == x && node.right.val == y) return false;
//                 if (node.left.val == y && node.right.val == x) return false;
//             }
//             if (node.left) queue.push(node.left);
//             if (node.right) queue.push(node.right);
//         }
//         if (xFound && yFound) return true;
//         if (xFound || yFound) return false;
//     }
//     return false;
// };

// DFS
let xParent,
    yParent,
    xDepth,
    yDepth;
var isCousins = function(root, x, y) {
    if (root == null) return false;
    dfs(root, x, y, 0, null);
    return xDepth == yDepth && xParent != yParent;
};

var dfs = function(root, x, y, depth, parent) {
    // Base Case
    if (root == null) return;

    // Logic
    if (root.val == x) {
        xDepth = depth;
        xParent = parent;
    }
    if (root.val == y) {
        yDepth = depth;
        yParent = parent;
    }
    dfs(root.left, x, y, depth + 1, root);
    dfs(root.right, x, y, depth + 1, root);
};
