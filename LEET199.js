Time complexity : O(N) : BFS solution using queue
 Space complexity : O(N) 

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var rightSideView = function(root) {
    const result = [];
    const queue = [];
    
    if (root === null) return result;
    
    queue.push(root);
    while(queue.length !== 0) {
        let size = queue.length;
        for (let i = 0; i < size; i++) {
            let n = queue.shift();
            if (i === size - 1) result.push(n.val);
            if (n.left !== null) queue.push(n.left);
            if (n.right !== null) queue.push(n.right);
        }
    }
    
    return result;
};