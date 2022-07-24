// Time Complexity : o(n) 
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q=new LinkedList();
        //result.add(root.val);
        q.add(root);
       
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode t=q.poll();
                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
                if(i==size-1){
                    result.add(t.val);
                }
            }
    
        }
        return result;
    }
}