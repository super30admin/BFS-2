//TC:O(n)
//SC: O(log n)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        TreeNode prev=root;
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            if(cur==null){
                if(q.isEmpty() || q.peek()==null){
                    if(prev!=null) res.add(prev.val);
                    return res;
                }
                q.add(null);
                res.add(prev.val);
                continue;
            }
            if(cur.left!=null) q.add(cur.left);
            if(cur.right!=null) q.add(cur.right);
            prev=cur;
        }
        return res;
    }
}