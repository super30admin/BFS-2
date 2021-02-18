class CousinsTree{
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<TreeNode, Integer>(root, -1));
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            int parent_x = -1;
            int parent_y = -1;
            
            for(int i=0; i<size; i++){
                Pair<TreeNode, Integer> first = queue.poll();
                
                TreeNode node = first.getKey();
                int parent = first.getValue();
                
                if(node.val == x){
                    parent_x = parent;
                }
                else if(node.val == y){
                    parent_y = parent;
                }
                
                if(node.left != null){
                    queue.add(new Pair<TreeNode, Integer>(node.left, node.val));
                }
                
                if(node.right != null){
                    queue.add(new Pair<TreeNode, Integer>(node.right, node.val)); 
                }
            }
            
            if(parent_x != -1 && parent_y != -1 && parent_x != parent_y){
                return true;
            }
            
        }
        
        return false;
    }
}