/**
 * @param {TreeNode} root
 * @param {number} x
 * @param {number} y
 * @return {boolean}
Intuition:
To determine if two nodes in a binary tree are cousins, we perform a level-order traversal (BFS) of the tree. 
At each level, we check whether both target nodes appear and also ensure they are not siblings by checking if they share the same parent.
 If both nodes are found at the same level and are not siblings, they are cousins.
By processing the tree level by level, we can simultaneously track the presence of the target nodes and verify their parentage,
allowing us to return `true` as soon as the cousin condition is met or `false` if it cannot be satisfied.
T.C: O(N)
S.C: O(N)

 */
var isCousinsBFS = function (root, x, y) {
    const queue = [root];
    let idx = 0;
    while (idx < queue.length) {
        const currLevelLength = queue.length - idx;
        let xSeen = false, ySeen = false;
        for (let i = 0; i < currLevelLength; i++) {
            const currEle = queue[idx++];
            // check if x and y are siblings
            const leftIsX = currEle.left && currEle.left.val === x;
            const rightIsY = currEle.right && currEle.right.val === y;
            const leftIsY = currEle.left && currEle.left.val === y;
            const rightIsX = currEle.right && currEle.right.val === x;

            if ((leftIsX && rightIsY) || (leftIsY && rightIsX)) return false;

            if (currEle.val === x) xSeen = true;
            if (currEle.val === y) ySeen = true;
            if (xSeen && ySeen) return true;
            if (currEle.left) queue.push(currEle.left);
            if (currEle.right) queue.push(currEle.right);
        }
    }
    return false;
};