// n is total nodes of tree
// h is the tree's height

// DFS:
// Time Complexity :
// O(n)
// Space Complexity:
// O(h)

// BFS:
// Time Complexity :
// O(n)
// Space Complexity:
// O(n)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)
// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

// Post order traversal
let result;
let dfs = (root, level) => {
    // Base case
    if (root === null) return;

    // Logic
    if (result.length === level) {
        result.push(root.val);
    }
    dfs(root.right, level + 1);
    dfs(root.left, level + 1);
}

/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var rightSideView = function (root) {
    if (root === null)
        return [];

    // DFS
    result = [];
    dfs(root, 0);

    // BFS
    //     let q = [];
    //     let result = [];
    //     q.push(root);

    //     while(q.length > 0){
    //         let size = q.length;
    //         for(let i=0; i<size; i++){
    //             let node = q.shift();
    //             if(i === size-1)
    //                 result.push(node.val);

    //             if(node.left !== null)  q.push(node.left);
    //             if(node.right !== null)  q.push(node.right);
    //         }
    //     }

    return result;
};