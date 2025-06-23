//The calDepthAndParent function recursively traverses the tree, updating the depth and parent of nodes x and y when found. After traversal, isCousins checks if both nodes are at the same depth but have different parents to determine if they are cousins.
//Time Complexity: O(n)
//Space Complexity: O(h)

class Solution {

   int x_depth=-1;

   int y_depth=-1;

   TreeNode x_parent=null;

   TreeNode y_parent=null;

   public boolean isCousins(TreeNode root, int x, int y) {

       calDepthAndParent(root,x,y,0,null);

       return x_depth == y_depth && x_parent!=y_parent;

   }

   public void calDepthAndParent(TreeNode root,int x,int y,int depth, TreeNode parent){

       if(root==null)

           return;

       if(root.val==x)

       {  x_parent=parent;

           x_depth=depth;}

       if(root.val==y)

       {y_parent=parent;

           y_depth=depth;}

       calDepthAndParent(root.left,x,y,depth+1,root);

       calDepthAndParent(root.right,x,y,depth+1,root);

   }

}