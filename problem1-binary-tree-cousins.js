//** https://leetcode.com/problems/cousins-in-binary-tree/
//// Time Complexity : O(n) we visit all nodes
//// Space Complexity : O(n) recursive stack (it would be O(1) iterative)
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :

// remembering recursive

//// Your code here along with comments explaining your approach

// track level and parent

// root's parent and level are null and 0

// recurse the tree, storing parent and depth any time you encounter X or Y
// if you've found X and Y,
//    return true if parents are different and depths are the same
// else
//    return false
var TreeNode, isCousins, tree;

TreeNode = function(value = -1, left = null, right = null) {
  return Object.assign(Object.create(TreeNode.prototype), {
    value: value,
    left: left,
    right: right
  });
};

isCousins = function(root, x, y) {
  var depthX, depthY, parentX, parentY, recurse;
  parentX = -1;
  parentY = -1;
  depthX = -1;
  depthY = -1;
  recurse = function(root, parent, depth) {
    if (root === null) {
      return;
    }
    if (root.val === x) {
      parentX = parent;
      depthX = depth;
    }
    if (root.val === y) {
      parentY = parent;
      depthY = depth;
    }
    recurse(root.left, root.val, depth + 1);
    return recurse(root.right, root.val, depth + 1);
  };
  recurse(root, null, 0);
  if (parentX === -1 || parentY === -1) {
    return false;
  }
  return depthX === depthY && parentX !== parentY;
};

tree = TreeNode(1, TreeNode(2, TreeNode(4), TreeNode(5, TreeNode(7))), TreeNode(3, TreeNode(6, TreeNode(8))));

isCousins(tree, 4, 6) === true;

isCousins(tree, 4, 5) === false;

//        1
//     /     \
//    2       3
//   /  \     /
//  4   5    6
//      /   /
//     7   8

//# sourceMappingURL=problem1-binary-tree-cousins.js.map
