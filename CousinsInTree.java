public class CousinsInTree {
  /**
   * Time Complexity: O(n)
   *    - we have to traverse over all nodes in the Tree
   * 
   * Space Complexity: O(n)
   *    - On a complete Binary Tree, we would have n/2 nodes at the last level
   * 
   */

  public boolean isCousins(TreeNode root, int x, int y) {
    Queue<TreeNode> queue = new LinkedList<>();
    
    queue.add(root);
    // if(root.left != null && root.right != null && 
    //   (root.left.val == x && root.right.val == y)
    while(!queue.isEmpty()){
        int size = queue.size();
        
        boolean x_found = false;
        boolean y_found = false;
        for(int i = 0; i < size; i++){
            TreeNode curr = queue.remove();
            
            // mark the booleans when nodes are found.
            if(curr.val == x){ x_found = true; }
            if(curr.val == y){ y_found = true; }
            
            // if they are found at the same level, return true
            if(x_found && y_found) { return true; }
            
            // check that they are not coming from the same parent
            if(curr.left != null && curr.right != null){
                if((curr.left.val == x && curr.right.val == y) ||
                   (curr.left.val == y && curr.right.val == x)){
                    return false;
                }
            }
            
            if(curr.left != null) { queue.add(curr.left); }
            if(curr.right != null) { queue.add(curr.right); }
        }
    }
    
    return false;
  }
}
