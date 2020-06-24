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
 * @param {number} x
 * @param {number} y
 * @return {boolean}
 */

let x_parent;
let y_parent;
let x_depth ;
let y_depth ;
var isCousins = function(root,parent, x, y) {
    if(root == null) return false;
    helper(root,null,0,x,y);
    return (x_depth == y_depth && x_parent != y_parent);
};

var helper = function(root,parent,depth,x,y){
    if(root == null) return;
    
    if(root.val == x){
        x_parent = parent;
        x_depth = depth;
    }
    
    if(root.val == y){
        y_parent = parent;
        y_depth = depth;
    }
    
    helper(root.left,root,depth+1,x,y);
    helper(root.right,root,depth+1,x,y);
}