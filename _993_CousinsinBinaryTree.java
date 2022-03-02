class Solution {

  // Time Complexity : o(n) n = number of nodes
  // Space Complexity :  o(n) n = number of nodes
  // Did this code successfully run on Leetcode : Yes
  // Any problem you faced while coding this : No

  // Your code here along with comments explaining your approach
  //Approach : pre order traversal , passing parent and level at each level

    int levelX = Integer.MIN_VALUE;
    int levelY = Integer.MAX_VALUE;

    int parentX = Integer.MIN_VALUE;
    int parentY = Integer.MAX_VALUE;

// using pre order
    public boolean isCousins(TreeNode root, int x, int y) {
        preorder(root.left, root, x, y,1);
        preorder(root.right, root, x, y,1);
        return (levelX == levelY) && (parentX != parentY);
    }

    public void preorder(TreeNode root, TreeNode parent, int x, int y, int level){
        if(root == null) return;

        if(root.val == x ){
            levelX = level;
            parentX = parent.val;
        }
        else if(root.val == y ){
            levelY = level;
            parentY = parent.val;
        }

        preorder(root.left, root, x, y,level+1);
        preorder(root.right, root, x, y,level+1);
    }

    //same code as above, using in order
/******************************************************/
    public boolean isCousins(TreeNode root, int x, int y) {
        inorder(root.left, root, x, y,1);
        inorder(root.right, root, x, y,1);
        return (levelX == levelY) && (parentX != parentY);
    }

    public void inorder(TreeNode root, TreeNode parent, int x, int y, int level){
        if(root == null) return;


        inorder(root.left, root, x, y,level+1);

        if(root.val == x ){
            levelX = level;
            parentX = parent.val;
        }
        else if(root.val == y ){
            levelY = level;
            parentY = parent.val;
        }

        inorder(root.right, root, x, y,level+1);
    }

//same cod as above, using post order
    /******************************************************/

    public boolean isCousins(TreeNode root, int x, int y) {
        postorder(root.left, root, x, y,1);
        postorder(root.right, root, x, y,1);
        return (levelX == levelY) && (parentX != parentY);
    }

    public void inorder(TreeNode root, TreeNode parent, int x, int y, int level){
        if(root == null) return;

        postorder(root.left, root, x, y,level+1);
        postorder(root.right, root, x, y,level+1);

        if(root.val == x ){
            levelX = level;
            parentX = parent.val;
        }
        else if(root.val == y ){
            levelY = level;
            parentY = parent.val;
        }
    }
}
