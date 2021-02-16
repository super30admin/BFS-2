//Time complexity:O(n)
//Space complexity:O(Max breadth)
//Code ran on leetcode:No
//Solution with approach:Trie implementing BFS but i guess it requires more space
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null)
            return false;
        q.add(root);
        int index=0;
        boolean foundx=false, foundy=false;
        int parentx=-1;
        int parenty=-2;
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode n = q.poll();
                if(n.val==x){foundx=true;parentx=(index)/2; }
                if(n.val==y){foundy =true; parenty=(index)/2;}
                if(n.left!=null) q.add(n.left);
                else
                    index++;
                index++;
                if(n.right!=null) q.add(n.right);
                else
                    index++;
                index++;
                
            }
            if((foundx!=foundy) || (parentx == parenty))
                return false;
        }
        return true;
        
    }

}
