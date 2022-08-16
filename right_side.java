//TimeComplexity - O(n)
//Space - O(n/2)- O(n)

class Solution {
    List<Integer> res = new ArrayList();
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        if(root==null)
            return res;
        q.add(root);
        while(!q.isEmpty()){
            int n=q.size();
            for(int i=0;i<n;i++){
                TreeNode node = q.poll();
                if(i==n-1){
                    res.add(node.val);
                }
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
        }
        return res;
    }
}
