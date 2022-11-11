
// TC : O(n)
// SC : O(n)

package S30_Codes.BFS_2;
import java.util.LinkedList;
import java.util.Queue;

class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root.val == x || root.val == y)
            return false;

        Integer xParent = null;
        Integer yParent = null;

        Queue<TreeNode> curQueue = new LinkedList<>();
        curQueue.add(root);

        while( !curQueue.isEmpty() ){
            Queue<TreeNode> nextQueue = new LinkedList<>();

            while(!curQueue.isEmpty()){
                TreeNode node = curQueue.poll();

                if(node.left != null){
                    if(node.left.val == x)
                        xParent = node.val;
                    if(node.left.val == y)
                        yParent = node.val;
                    nextQueue.add(node.left);
                }
                if(node.right != null){
                    if(node.right.val == x)
                        xParent = node.val;
                    if(node.right.val == y)
                        yParent = node.val;
                    nextQueue.add(node.right);
                }
            }

            if(xParent != null || yParent != null)
                break;

            curQueue = nextQueue;
        }

        if(xParent != null && yParent != null && xParent != yParent)
            return true;

        return false;
    }
}