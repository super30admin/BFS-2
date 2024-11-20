/*
 * Tc - O(n)
 * SC - O(n)
 * Approach - using dfs stack based, we are adding parent, curr, and depth to 
 * the stacks, and then comparing if value is equal to x y we update level and depth 
 * and in the end make sure that xparent and yparent are not equal
 */

public class Cousins{
    //dfs using custom stack
    public boolean isCousins(TreeNode root, int x, int y){
        Stack<TreeNode> nodes = new Stack<>();
        Stack<TreeNode> parents = new Stack<>();
        Stack<Integer> depths = new Stack<>();

        nodes.push(root);
        parents.push(null);
        depths.push(0);
        int xLevel = -1, yLevel = -1;
        TreeNode xParent = null, yParent = null;
        
        while(!nodes.isEmpty()){
            TreeNode curr = nodes.pop();
            TreeNode parent = parents.pop();
            int depth = depths.pop();
            if(curr.val == x){
                xLevel = depth;
                xParent = parent;
            }
            if(curr.val == y){
                yParent = parent;
                yLevel = depth;
            }
            if(curr.left != null){
                nodes.push(curr.left);
                parents.push(curr);
                depths.push(depth+1);
            }
            if(curr.right != null){
                nodes.push(curr.right);
                parents.push(curr);
                depths.push(depth+1);
            }
        }
        return xLevel == yLevel && xParent != yParent;
    }


    // int xLevel, yLevel;
    // TreeNode xParent, yParent;
    // public boolean isCousins(TreeNode root, int x, int y) {
    //     this.xLevel = -1;
    //     this.yLevel = -1;
    //     this.xParent = null;
    //     this.yParent = null;
    //     helper(root, 0, null,x,y);
    //     return xLevel == yLevel && xParent != yParent;
    // }

    // public void helper(TreeNode node, int depth, TreeNode parent, int x, int y){
    //     //base
    //     if(node == null) return;
    //     if(xParent != null && yParent != null)  return;

    //     //logic 
    //     if(node.val == x){
    //         xLevel = depth;
    //         xParent = parent;
    //     }
    //     if(node.val == y){
    //         yLevel = depth;
    //         yParent = parent;
    //     }
        
    //     //recurse 
    //     helper(node.left, depth+1, node, x, y);
    //     helper(node.right, depth+1, node, x, y);
    // }

    // public boolean isCousins(TreeNode root, int x, int y) {
    //     if(root == null) return false;
    //     Queue<TreeNode> nodes = new LinkedList<>();
    //     Queue<TreeNode> parents = new LinkedList<>();
    //     nodes.offer(root);
    //     parents.offer(null);
    //     boolean xFound = false, yFound = false;
    //     TreeNode xParent = null, yParent = null;
    //     while(!nodes.isEmpty()){
    //         int size = nodes.size();
    //         xFound = false;
    //         yFound = false;
    //         for(int i = 0; i < size; i++){
    //             TreeNode curr = nodes.poll();
    //             TreeNode parent = parents.poll();
    //             if(curr.val == x){
    //                 xFound = true;
    //                 xParent = parent;
    //             }
    //             if(curr.val == y){
    //                 yFound = true;
    //                 yParent = parent;
    //             }
    //             if(curr.left != null){
    //                 nodes.offer(curr.left);
    //                 parents.offer(curr);
    //             }
    //             if(curr.right != null){
    //                 nodes.offer(curr.right);
    //                 parents.offer(curr);
    //             }

    //         }
    //         if(xFound && yFound){
    //             return xParent != yParent;
    //         }
    //         if(xFound || yFound) return false;
    //     }
    //     return true;
    // }
}