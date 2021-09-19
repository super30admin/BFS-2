// Time Complexity : O(n)  
// Space Complexity :O(n)   
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        boolean foundx=false,foundy=false;
        LinkedList<TreeNode> q=new LinkedList<>();
        if(root==null)return false;
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
            TreeNode temp=q.poll();
            if(temp.val==x)foundx=true;
            if(temp.val==y)foundy=true;
                if(temp.left!=null && temp.right!=null)
                {
                    if(temp.left.val==x && temp.right.val==y){return false;}
                    if(temp.left.val==y && temp.right.val==x){return false;}
                }
                if(temp.left!=null){q.add(temp.left);}
                if(temp.right!=null){q.add(temp.right);}
                
            }
            if(foundx && foundy){return true;}
            if(foundx || foundy){return false;}
        }
        return false;
    }
}