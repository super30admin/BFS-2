/**
 * TimeComplexity O(N)
 * SpaceComplexity O(H)
 */
class RightSide {
    
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> rightList=new ArrayList<>();
        
        if(root==null){
            return rightList;
        }
        
        q.add(root);
        
        while(!q.isEmpty()){
            
            int size=q.size();
            
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                
                if(i==size-1){
                    rightList.add(node.val);
                }
                
                if(node.left!=null){
                    q.add(node.left);
                    
                }
                
                if(node.right!=null){
                    q.add(node.right);
                    
                }
            }
            
        }
        
        return rightList;
    }
}
