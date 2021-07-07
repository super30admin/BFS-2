// Time Complexity :
//      n is the number of nodes in tree
//      isCousins() - O(n)
//      
// Space Complexity :
//      isCousins() - O(n)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    int l1 = -1, l2 = -1;
    TreeNode p1 = null, p2 = null;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null || (root.left == null && root.right == null))
            return false;
        
        Queue<Pair<TreeNode, Integer>> qu = new LinkedList<>();
        qu.offer(new Pair(root, 0));
        
        while(!qu.isEmpty() && (l1 == -1 || l2 == -1))
        {
            Pair<TreeNode, Integer> nodenode = qu.poll();
            
            TreeNode node = nodenode.getKey();
            int level = nodenode.getValue();
            
            if(node.left != null)
            {
                if(node.left.val == x || node.left.val == y)
                {
                    helper(node, level + 1);
                }
                
                qu.offer(new Pair(node.left, level+1));
            }
            
            if(node.right != null)
            {
                if(node.right.val == x || node.right.val == y)
                {
                    helper(node, level + 1);
                }
                
                qu.offer(new Pair(node.right, level+1));
            }
        }
        
        return ((l1 == l2) && (p1 != p2));
    }
    
    private void helper(TreeNode parent, int level)
    {
        if(l1 == -1)
        {
            l1 = level;
            p1 = parent;
            return;
        }
        
        else if(l2 == -1)
        {
            l2 = level;
            p2 = parent;
            return;
        }
    }
}