/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int xParent=0, yParent=0, xDepth=0, yDepth=0;
    public boolean isCousins(TreeNode root, int x, int y) {
        //edge case 
        if(root == null)
            return false;
        isCousinsUtilDFS(root, x, y, root, 0);
        return xDepth == yDepth &&  xParent != yParent;
        //return isCousinsUtilBFS(root, x, y);
       
    }
    /*
    Nodes are cousins if they have the same depth but different parents. 
    A straightforward would be to be able to know the parent and depth of each node.
    And if I found given nodes at the same level and from diff parents then I would be returning true
    Time Complexity-O(N)
    Time Complexity-O(H) 
    */
    private void isCousinsUtilDFS(TreeNode root, int x, int y, TreeNode parent, int level){
        if(root == null)
            return;
        
        if(x == root.val){
            xDepth = level;
            xParent = parent.val;
        }
        if(y == root.val){
            yDepth = level;
            yParent = parent.val;
        }

        isCousinsUtilDFS(root.left, x, y, root, level+1);
        isCousinsUtilDFS(root.right, x, y, root, level+1);
    }
    /* BFS solution
    Time complexity : O(n) as we are visiting all the nodes
    Space complexity : O(2n), in worst case if its a complete binary tree then maximum number of nodes     is going to lie on the deepest level which would be O(2n) and that is equal to O(n)
    */
     private boolean isCousinsUtilBFS(TreeNode root, int x, int y){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            boolean xFound = false, yFound= false;
            int size = q.size();
            for(int i =0 ; i< size; i++){
                //pop the node from the queue
                TreeNode node = q.poll();
                //logic
                if(node.val == x ) xFound = true;
                if(node.val == y ) yFound = true;   
    
                //check if x and y belongs to same parent
                if(node.left != null && node.right != null){
                    if(node.left.val ==x && node.right.val == y) 
                        return false;
                    if(node.left.val ==y && node.right.val == x) 
                        return false;
                }
                
                //process all children of the popped node
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right); 
            }
            //cousins found at the same level
            if(xFound &&  yFound) return true;
            
            //nodes are not on the same level, cant be cousin.
            if(xFound || yFound) return false;
            
        }
        return false;
     }
}
