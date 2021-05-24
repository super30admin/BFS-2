public class BinaryTreeCousins {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        
        // Base Condition to be checked.
        if(root == null || x == y) return false;
        
        // Initialize queue for performing the level order traversal.
        Queue<TreeNode> q = new LinkedList<>();
        
        // Add the root node into the queue to initialize the traversal.
        q.add(root);
        
        // To keep track of the nodes.

        //   1. At what level did we find the nodes x & y.
        boolean x_found = false;
        boolean y_found = false;

        //   2. What are the parents of nodes x & y.
        TreeNode x_parent = null;
        TreeNode y_parent = null;
        
        // Run the traversal until the queue is empty.
        // When the queue is empty, then we have traversed all the nodes in the list.
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                
                // In correct scenario actual nodes should be found at level H-1
                // Boolean to check if we have found the nodes x and y.
                if(curr.val == x) x_found = true;
                if(curr.val == y) y_found = true;
                
                // In correct scenario parent nodes are set at level H
                // Setting the parent element to either x node or y node for the left child associated to the current node.
                if(curr.left != null){
                    if(curr.left.val == x) x_parent = curr;
                    if(curr.left.val == y) y_parent = curr;
                    q.add(curr.left);
                }
                
                // Setting the parent element to either x node or y node for the right child associated to the current node.
                if(curr.right != null){
                    if(curr.right.val == x) x_parent = curr;
                    if(curr.right.val == y) y_parent = curr;
                    q.add(curr.right);
                }
                
            }
            
            // This below checks happen at level H-1
            //    At level H-1, if we have found the node x but not y or vice versa then we can safely tell that node x & y are not cousins since they are not in same level.
            if((x_found && !y_found) || (!x_found && y_found)) return false;
            
            //    At level H-1, if we have found both the nodes then we check if the parents of each node are different. 
            //    Only then we an say that both the nodes are cousins.
            if(x_found && y_found){
                if(x_parent.val != y_parent.val) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        
    }
    
}
