//TimeComplexity - O(n)
//Space - O(n/2)- O(n)

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        boolean foundX;
        boolean foundY;
        while(!q.isEmpty()){
            int n=q.size();
            foundX= false;
            foundY= false;
            for(int i=0;i<n;i++){
                TreeNode node = q.poll();
                if(node.left!=null && node.right!=null){
                    if((node.left.val==x && node.right.val==y) || (node.left.val==y && node.right.val==x))
                        return false;
                }
                if(node.left!=null){
                    if(node.left.val==x)
                        foundX = true;
                    if(node.left.val==y)
                        foundY = true;
                    q.add(node.left);
                }
                if(node.right!=null){
                    if(node.right.val==x)
                        foundX = true;
                    if(node.right.val==y)
                        foundY = true;
                    q.add(node.right);
                }
                if(foundX && foundY)
                    return true;
            }
        }
        return false;
    }
}
