Time complexity : O(N)
 Space complexity : O(H)
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
var isCousins = function(root, x, y) {
    var xcount=0,ycount=0;
    var xparent=null,yparent=null,depth=0;
    check(root,x,y,0,null);
    return xcount===ycount && xparent!=yparent;
    function check(root,x,y,depth,parent){
        if(root===null)
        {
            return true;
        }
        if(root.val===x){
          xparent = parent;
          xcount = depth;
        }
    else if(root.val===y){
          yparent = parent;
          ycount = depth;
            
        }
        check(root.left,x,y,depth+1,root);
        check(root.right,x,y,depth+1,root);
    }
    
};
    