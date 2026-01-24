/**
 * @param {TreeNode} root
 * @return {number[]}
The intuition behind this solution is to use breadth-first search to process the tree one level at a time, because the right side view depends on which node appears last at each depth.
We keep a queue to traverse nodes level by level, and for each level we calculate how many nodes belong to it (currLength). 
As we iterate through those nodes, the last node processed in that level represents the node visible from the right side, so we add its value to the result array. While traversing, we push each node’s left and right children into the queue to be processed in the next level. By repeating this for all levels, we collect exactly one value per level i.e., the rightmost node—forming the right side view of the binary tree. 
T.C: O(N)
S.C: O(N)
*/
 
var rightSideViewBFS = function (root) {
    const res = [];
    // base case
    if (!root) return res;
    // bfs
    const queue = [root];
    let idx = 0;
    while (idx < queue.length) {
        const currLength = queue.length - idx;
        for (let i = 0; i < currLength; i++) {
            const node = queue[idx++];
            if (i === currLength - 1) res.push(node.val);
            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);
        }
    };
    return res;
};