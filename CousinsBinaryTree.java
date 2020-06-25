// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach


//recursive
class Solution {
    
    int x_depth;
    int y_depth;
    TreeNode x_parent;
    TreeNode y_parent;
    int a;
    int b;
    public boolean isCousins(TreeNode root, int x, int y) {
        a = x;
        b = y;
        helper(root,0,null);
        if(x_depth == y_depth && x_parent != y_parent)
            return true;
        return false;
    }
    
    private void helper(TreeNode root,int depth,TreeNode parent){
        
        
        if(root  ==  null)
            return;
        if(root.val == a)
        {
            x_depth = depth;
            x_parent = parent;
        }
        if(root.val == b)
        {
            y_depth = depth;
            y_parent = parent;
        }
        helper(root.left,depth+1,root);
        helper(root.right,depth+1,root);
        
        return;
    }
}


//iterative



// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue  = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int length = queue.size();
            boolean xFound = false;
            boolean yFound =  false;
            for(int i = 0 ;i < length ; i++){
            TreeNode cur  = queue.poll();
            
            if(cur.val == x)
                xFound = true;
            if(cur.val == y)
                yFound = true;
            if(cur.left!=null && cur.right!=null) {
                if(cur.left.val == x && cur.right.val == y)
                   return false;
             if(cur.left.val == y && cur.right.val == x)
                  return false;
            }
            if(cur.left != null)
                queue.add(cur.left);
            if(cur.right !=null  )
                queue.add(cur.right);
            
             }
            if(xFound && yFound)
                return true;
            if(xFound || yFound)
                return false;
        }
        
        return false;
    }
}