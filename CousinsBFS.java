//TIME COMPLEXITY:O(n)
//Space Complexity:O(n)

//BREADTH FIRST SEARCH
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        Queue<TreeNode> q=new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            boolean xpresent=false;
            boolean ypresent=false;
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                int val=curr.val;
                if(curr.val==x){
                    xpresent=true;
                }
                if(curr.val==y){
                    ypresent=true;
                }
                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val==x && curr.right.val==y){
                        return false;
                    }
                    if(curr.right.val==x && curr.left.val==y){
                        return false;
                    }
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            if(xpresent && ypresent){
                return true;
            }
        }
        return false;
    }
}