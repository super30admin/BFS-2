/**
 *
 *  Time Complexity: O(N) Where N is the number of nodes in the tree.
 *  Space Complexity: O(N) Since in the worst case for BFS it would be the number of nodes in the lowest level which is N/2. When we use DFS it would take log(N) stack space, where h is the height of the tree.
 *
 *  Did this code successfully run on Leetcode : Yes
 *  Any problem you faced while coding this : None
 *
 *  Explanation: If we are using BFS we can simply use a size variable to keep track of all the nodes in the same size. To make sure that the element are not sibilings, we can have a simple conditional check for left and right child of a node. Else if we find both the element when we proccess all the elements in the same level we return true else fasle.
 */
class Solution {
    TreeNode xNode, yNode;
    int xDepth, yDepth;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        xDepth=-1;
        yDepth=-1;
        dfs(root, null, x, y, 0);
        
        if((xNode!=yNode ) && (xDepth==yDepth)) return true;
        return false;
    }
    private void dfs(TreeNode root, TreeNode parent, int x, int y, int depth){
        if(root==null || (xNode!=null && yNode!=null)) return;
        if(xDepth!=-1 && (depth>xDepth) || (yDepth!=-1 && depth>yDepth)){
            return;
        }
        if(root.val==x){
            xNode=parent;
            xDepth=depth;
        }
        if(root.val==y){
            yNode=parent;
            yDepth=depth;
        }
        if(root.left!=null) dfs(root.left, root, x, y, depth+1);
        if(root.right!=null) dfs(root.right, root, x, y, depth+1);
    }
    
}
    // public boolean isCousins(TreeNode root, int x, int y) {
    //     if(root==null) return false;
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);
    //     while(!queue.isEmpty()){
    //         int size = queue.size();
    //         boolean isXFound = false, isYFound=false;
    //         while(size>0){
    //             TreeNode node = queue.poll();
    //             if(node.val==x){
    //                 isXFound=true;
    //             }
    //             else if(node.val==y){
    //                 isYFound=true;
    //             }
    //             if(node.left!=null && node.right!=null){
    //                 if((node.left.val==x && node.right.val==y) || (node.left.val==y && node.right.val==x)){
    //                     return false;
    //                 }
    //             }
    //             if(node.left!=null) queue.offer(node.left);
    //             if(node.right!=null) queue.offer(node.right);
    //             --size;
    //         }
    //         if(isYFound && isXFound) return true;
    //         if(isXFound || isYFound) return false;
    //     }
    //     return false;
    // }
// }
