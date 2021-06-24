class Solution {
    // Time complexity: O(n)
    // Space complexity: O(n)
    public boolean isCousins(TreeNode root, int x, int y) {
        // firstly we should know definition of cousin nodes:
        // nodes which havd different parents but on the same level.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // since we only have two inputs x and y, when we find count = 2, that means 
        // we find x and y are cousins.
        int count = 0;
        boolean sibling = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node == null){
                    sibling = false;
                }else{
                    if(node.val == x || node.val == y){
                    // check whether node has same parents
                        if(sibling == false){
                            count++;
                            sibling = true;
                        }
                    }
                    queue.add(null);
                    if(node.left != null){
                        queue.add(node.left);
                    }
                    if(node.right != null){
                        queue.add(node.right);
                    }
                    if(count == 2){
                        return true;
                    }
                }
                
            }
            count =0;
           
        }
        return false;
    }
    
}