// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach: BFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;

        Queue<TreeNode> q= new LinkedList<>();
        
        q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0; i<size;i++){
                TreeNode curr=q.poll();
                if(i==size-1){
                    result.add(curr.val);
                }
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
           
            }
            

        }
    return result;
    }
}