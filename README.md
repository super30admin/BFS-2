# BFS-2

## Problem 1

Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)
class Solution {
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result= new ArrayList<>();
       if(root==null) return new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty())
        {
            int count=q.size();
            for(int i=0;i<count;i++)
            {
                TreeNode curr= q.poll();
                if(i==count-1) result.add(curr.val);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
                
            }
        }
        return result;
}
}
Time Complexity : O(n)
Space Complexity :O(n/2) at a time stack stores only children


## Problem 2

Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        boolean X_found=false,Y_found=false;
        q.add(root);
        while(!q.isEmpty())
        {
            List<Integer> temp = new ArrayList<>();
            int count=q.size();
            for(int i=0;i<count;i++)
            {
                TreeNode curr= q.poll();
                if(curr.val==x)  X_found=true;
                if(curr.val==y)  Y_found=true;
                if(curr.right!=null && curr.left!=null)
                {
                    if(curr.right.val==x && curr.left.val==y) return false;
                    if(curr.right.val==y && curr.left.val==x) return false;
                    
                }
                
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
                
            }
             if(X_found && Y_found) return true;
             if(X_found || Y_found) return false;
        }
       
        
        return false;
       
    }
     
}
Time Complexity : O(n)
Space Complexity :O(n/2) at a time stack stores only children