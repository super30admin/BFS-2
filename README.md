# BFS-2

## Problem 1

Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

class Solution {

   public List<Integer> rightSideView(TreeNode root) {

       List<Integer> result = new ArrayList<>();

       view(root,result,0);

       return result;

   }

   public void view(TreeNode root,List result,int depth){

       if(root==null) return;

       if(depth==result.size())

           result.add(root.val);

       view(root.right,result,depth+1);

       view(root.left,result,depth+1);

   }

}

## Problem 2

Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)

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


