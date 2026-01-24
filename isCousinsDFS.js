/**
 * @param {TreeNode} root
 * @param {number} x
 * @param {number} y
 * @return {boolean}
Intuition:
To check if two nodes are cousins in a binary tree, we need to know both their depth and their parent.
Using DFS, we traverse the tree recursively while keeping track of each node’s depth and parent.
When we encounter one of the target nodes (`x` or `y`), we record its depth and parent. 
After traversing the entire tree, the two nodes are cousins if they are at the **same depth** but have **different parents**.
T.C: O(N)
S.C: O(N)
 */
var isCousinsDFS = function (root, x, y) {
    let xDepth = 0, yDepth = 0;
    let xParent = null, yParent = null;
    const dfs = (root, parent, level) => {
        // base case
        if (!root) return;

        // action
        if (root.val === x) {
            xDepth = level;
            xParent = parent;
        };

        if (root.val === y) {
            yDepth = level;
            yParent = parent;
        }

        // recursion
        dfs(root.left, root, level + 1);
        dfs(root.right, root, level + 1);
    };
    dfs(root, null, 1);
    return xDepth === yDepth && xParent !== yParent;
};