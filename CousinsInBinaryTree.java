// Time Complexity : O(n)
// Space Complexity : O(h) , h = height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Create a recursive function with a local variable as height of the tree, and goto the leftmost sub tree, while checking if the root is parent of either X or Y, and then goto the right sub tree. Once parents of X and Y and their respective heights are found, then check if they are cousins.

public class CousinsInBinaryTree {

    //Solution 1: DFS
    TreeNode parentX;
    TreeNode parentY;
    int heightX;
    int heightY;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        
        helper(root, x, y, 0);
        return parentX != parentY && heightX == heightY;
    }
    
    private void  helper(TreeNode root, int x, int y, int height){
        if(parentX != null && parentY != null || root == null) return;
        
        if((root.left != null && root.left.val == x) || (root.right != null && root.right.val == x)) {
            parentX = root;
            heightX = height+1;
            return;
        }
        
        if((root.left != null && root.left.val == y) || (root.right != null && root.right.val == y)) {
            parentY = root;
            heightY = height+1;
            return;
        }
        
        helper(root.left, x, y, height + 1);
        helper(root.right, x, y, height + 1);
    }

    //Solution 2: BFS
    // TreeNode parentX;
    // TreeNode parentY;
    
    // public boolean isCousins(TreeNode root, int x, int y) {
    //     if(root == null) return false;
        
    //     Queue<TreeNode> q = new LinkedList<>();
        
    //     q.add(root);
        
    //     while(!q.isEmpty()){
    //         int size = q.size();
            
    //         for(int i = 0; i < size; i++ ){
    //             TreeNode curr = q.poll();
                
    //             if((curr.left != null && curr.left.val == x) || (curr.right != null && curr.right.val == x)){
    //                 parentX = curr;
    //             }
    //             if((curr.left != null && curr.left.val == y) || (curr.right != null && curr.right.val == y)){
    //                 parentY = curr;
    //             }
                
    //             if(curr.left != null ) q.add(curr.left);
    //             if(curr.right != null ) q.add(curr.right);

    //         }
            
    //         if((parentX != null && parentY == null) || (parentX == null && parentY != null) ){
    //             return false;
    //         }
            
    //         if(parentX != null && parentY != null)
    //             break;
    //     }
    //     return !(parentX == parentY);

    // }
}
