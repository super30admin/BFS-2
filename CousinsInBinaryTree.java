// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach: BFS
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }

        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();
            boolean foundX = false;
            boolean foundY = false;
            for(int i=0; i<size; i++){
                TreeNode curr= q.poll();

                if(curr.left!=null && curr.right!=null){
                    if((curr.left.val==x && curr.right.val==y) || (curr.left.val==y && curr.right.val==x)){
                    return false;
                    }
                }

                if(curr.val==x){
                    foundX=true;
                }
                if(curr.val==y){
                    foundY=true;
                }
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
            if(foundX && foundY){
                return true;
            }

        }
        return false;
    }
}