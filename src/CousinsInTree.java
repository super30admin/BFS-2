// Time Complexity:           O(n)
// Space Complexity:          O(n)
// where n is number of nodes in tree
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

import java.util.LinkedList;
import java.util.Queue;

public class CousinsInTree {

// ****************************** Using BFS Approach ******************************

    private TreeNode xParent, yParent;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            
            int size = q.size();
            boolean foundX = false, foundY = false;
            
            while(size-- > 0) {
                
                TreeNode node = q.poll();

                if(node.val == x) {                                                    // if node value is x
                    foundX = true;
                }
                if(node.val == y) {                                                    // if node value is y
                    foundY = true;
                }
                if(node.left != null && node.right != null) {                          // if ndode has both left and right children
                    if(node.left.val == x && node.right.val == y) return false;        // both children having x and y values
                    if(node.left.val == y && node.right.val == x) return false;        // then siblings, not cousins
                }
                if(node.left != null) {                                                // adding left child
                    q.add(node.left);
                }
                if(node.right != null) {                                               // adding right child
                    q.add(node.right);
                }
            }

            if(foundX && foundY) {                                                     // if x and y found but not under same parent, but in same level; then hey are cousins
                return true;
            }
            else if(foundX || foundY) {                                                // if either only x or only y found
                return false;
            }

        }
        return false;
    }




// ****************************** Using DFS Approach ******************************
//
//    private TreeNode xParent, yParent;
//    private int xLevel, yLevel;
//    private int x, y;
//
//    public boolean isCousins(TreeNode root, int x, int y) {
//        xParent = yParent = null;
//        this.x = x;
//        this.y = y;
//        isCousins(root, null, 0);
//        return xLevel == yLevel && xParent != yParent;
//    }
//    private void isCousins(TreeNode root, TreeNode parent, int level) {
//        if(root == null)
//            return;
//
//        // PreOrder
//        if(root.val == x) {                            // traversing node
//            xLevel = level;
//            xParent = parent;
//        }
//        if(root.val == y) {
//            yLevel = level;
//            yParent = parent;
//        }
//
//        isCousins(root.left, root, level+1);           // traversing node's left child
//        isCousins(root.right, root, level+1);          // traversing node's right child
//    }
}
