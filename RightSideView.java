public class RightSideView {

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

    // ########################################################################
    // BFS approach.
    public static List<Integer> rightSideViewBfs(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        // Base Condition to be checked.
        if(root == null) return result;
        
        // Initialize queue for performing the level order traversal.
        Queue<TreeNode> q = new LinkedList<>();
        
        // Add the root node into the queue to initialize the traversal.
        q.add(root);
        
        // Run the traversal until the queue is empty.
        // When the queue is empty, then we have traversed all the nodes in the list.
        while(!q.isEmpty()){
            // Since we need to distinguish each level elements from the other level we use size variable.
            int size = q.size();
            
            // Process all the elements associated to the current level.
            for(int i = 0; i < size; i++){
                
                // Popping the top associated in the current level.
                // Add this val to the temp list.
                TreeNode curr = q.poll();
                
                // The last element of each level will be the visible element when viewed from right side of the tree.
                if(i == size-1) result.add(curr.val);
                
                // Adding the left and right child's to the queue for next level processing.
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        
        return result;
    }

    // ########################################################################
    // DFS Approach --> right traverse and then left traverse.
    public List<Integer> rightSideViewDfsRight(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        // Base Condition to be checked.
        if(root == null) return result;
        
        // Helper function to populate the result list.
        helperDfsRight(result, root, 0);
        
        // return the result once it is populated.
        return result;
    }
    
    public void helperDfsRight(List<Integer> result, TreeNode root, int level){
        // base case
        if(root == null) return;
        
        // logic
        // When we reach a node and see its level is equal to the size of the result array then we can add the current value to the result list.
        // The above scenario occurs only when the first right node of a particular level is reached int the recursive stack.
        // In other scenarios where the node is not the right most element, the length of the result array will be greater than the level associated to that node in which case we don't add the element to result.
        if(level == result.size()){
            result.add(root.val);
        }
        
        // Navigate to the right side of the current node.
        helperDfsRight(result, root.right, level+1);
        
        // Internally stack.pop() happened before the below function is called.
        
        // Once all the nodes associated to the right of the current node is processed, then we navigate to the Left Node.
        helperDfsRight(result, root.left, level+1);
    }

    // ########################################################################
    // DFS Approach --> left traverse and then right traverse.
    public List<Integer> rightSideViewDfsLeft(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        // Base Condition to be checked.
        if(root == null) return result;
        
        // Helper function to populate the result list.
        helperDfsLeft(result, root, 0);
        
        // return the result once it is populated.
        return result;
    }
    
    public void helperDfsLeft(List<Integer> result, TreeNode root, int level){
        // base case
        if(root == null) return;
        
        // logic
        // Since we are traversing the elements from left to right in a given level we add the value if it is the first element(Left most node) in a given level.
        // If it is not the first element, then we update the val at the corresponding index.
        // Since the right most element is the last node of the level that will be traversed, the result array will have the right most element at a specific index after the complete traversal.
        if(level == result.size()){
            result.add(root.val);
        }else{
            result.set(level, root.val);            
        }
        
        // Traverse to the left of the Node.
        helperDfsLeft(result, root.left, level+1);
        
        // Internally stack.pop() happened before the below function is called.
        
        // Traverse to the right of the Node.
        helperDfsLeft(result, root.right, level+1);
    }

    public static void main(String[] args) {
        
    }
    
}
