class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root ==null)
            return result;
        Queue<TreeNode> temp = new LinkedList<>();
        temp.add(root);
            while(!temp.isEmpty())
            {
                int sz = temp.size();
                for(int i=0;i<sz;i++)
                {
                    TreeNode curr = temp.poll();
                    if(i==sz-1)
                        result.add(curr.val);
                    if(curr.left!=null) temp.add(curr.left) ;
                    if(curr.right!=null) temp.add(curr.right) ;
                }
            }
        return result;
    }
}