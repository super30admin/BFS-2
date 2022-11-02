class Solution {
    public List<Integer> rightSideView(TreeNode root) {
         List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        if(root== null){
            return result;
        }
        while(!q.isEmpty()){
            TreeNode p = null;
            int si = q.size();
            while(si>0){
                TreeNode s = q.poll();
                if(s.left!=null){
                q.add(s.left);}
                if(s.right!=null){
                q.add(s.right);}
                --si;
                p = s;
            }
            result.add(p.val);
        }
        return result;
    }
}
//tc=O(n)
//sc=O(n)
