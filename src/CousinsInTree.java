// Time Complexity:           O(n)
// Space Complexity:          O(n)
// where n is number of nodes in tree
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    private TreeNode cur;
    private int parent;
    Pair(TreeNode cur, int parent) {
        this.cur = cur;
        this.parent = parent;
    }
    public TreeNode getCur() {return cur;}
    public int getParent() {return parent;}
}

public class CousinsInTree {

// ****************************** Using BFS Approach ******************************
    private TreeNode xParent, yParent;
    private int xLevel, yLevel;
    private int x, y;

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()) {
            int size = q.size();

            boolean foundX = false, foundY = false;
            int parentX = 0, parentY = 0;

            while(size-- > 0) {

                Pair p = q.remove();
                TreeNode node = p.getCur();

                // process
                if(node.val == x) {
                    foundX = true;
                    parentX = p.getParent();
                }
                if(node.val == y) {
                    foundY = true;
                    parentY = p.getParent();
                }

                if(foundX && foundY)                                                 // both found in same level then break
                    break;
                if(node.left != null && node.right != null) {                        // same parent
                    if(node.left.val == x && node.right.val == y) return false;
                    if(node.left.val == y && node.right.val == x) return false;
                }

                // add left
                if(node.left != null) q.add(new Pair(node.left, node.val));
                // add right
                if(node.right != null) q.add(new Pair(node.right, node.val));
            }

            if(foundX && foundY)                                                     // both found
                return parentX != parentY;
            if(foundX || foundY)                                                     // only one of them found
                return false;
        }
        return false;
    }




// ****************************** Using DFS Approach ******************************
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
