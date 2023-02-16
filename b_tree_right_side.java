//Time comoplexity O(N)
//Space Complexity O(H)

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>() ; 
        if(root == null) return result ; 
        Queue<TreeNode> q = new LinkedList<>() ; 

        q.add(root) ; 

        while(!q.isEmpty()){
            int size = q.size() ; 
            TreeNode curr = null ; 
            while(size > 0){
                curr = q.poll() ;
                if(curr.left != null){
                    q.add(curr.left) ; 
                }
                if(curr.right != null){
                    q.add(curr.right) ; 
                }

                size -- ; 
            }

            result.add(curr.val) ; 
            
        }

        return result ; 
    }
}
