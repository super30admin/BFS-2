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

let x_level, y_level, x_parent, y_parent;

let dfs = (root, x, y, level, parent) => {
    if (root === null)
        return;
    if (root.val === x) {
        x_parent = parent;
        x_level = level
    }
    if (root.val === y) {
        y_parent = parent;
        y_level = level
    }
    if (x_level !== null && y_level !== null)
        return;
    console.log(root.val)
    dfs(root.left, x, y, level + 1, root);
    dfs(root.right, x, y, level + 1, root);
}


/**
 * @param {TreeNode} root
 * @param {number} x
 * @param {number} y
 * @return {boolean}
 */
var isCousins = function (root, x, y) {
    if (root === null)
        return false;

    // DFS
    x_level = null;
    y_level = null;
    x_parent = null;
    y_parent = null;
    dfs(root, x, y, 0, null);
    return ((x_level === y_level) && (x_parent !== y_parent));
    //     // BFS
    //     let q = [];
    //     q.push(root);

    //     // Maintains if the number is found at a level
    //     let x_found = false;
    //     let y_found = false;

    //     while(q.length > 0){
    //         // Looping through each level
    //         let size = q.length;
    //         for(let i=0; i<size; i++){
    //             // Get 1st node
    //             let node = q.shift();
    //             if(node.val === x){
    //                 x_found = true;
    //             } else if (node.val === y){
    //                 y_found = true
    //             }
    //             // If it has 2 children and both are x and y, return false as same parent
    //             // Else add the not null children
    //             if(node.left !== null && node.right !== null){
    //                 if((node.left.val === x && node.right.val === y) || (node.left.val === y && node.right.val === x))
    //                     return false;
    //                 q.push(node.left);
    //                 q.push(node.right);
    //             } else if(node.left !== null){
    //                 q.push(node.left);
    //             } else if(node.right !== null){
    //                 q.push(node.right);
    //             }
    //         }
    //         // Level check
    //         // If both found in same level, return true
    //         if(x_found && y_found)
    //             return true;
    //         // If any one is true, return false;
    //         if(x_found)
    //             return false;
    //         if(y_found)
    //             return false;
    //     }
    //     return false;
};