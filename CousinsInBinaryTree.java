/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
            Queue<TreeNode> q = new LinkedList<>();
            Queue<TreeNode> pq = new LinkedList<>();
            q.add(root);
            pq.add(null);
            while(!q.isEmpty())
            {
                int size = q.size();
                boolean isX = false;
                boolean isY = false;
                TreeNode xp = null;
                TreeNode yp = null;
                for(int i=0;i<size;i++)
                {
                   TreeNode cur = q.poll();
                   TreeNode pcur = pq.poll();
                   if(cur.val == x)
                   {
                        isX = true;
                        xp = pcur;
                   } 
                   if(cur.val == y)
                   {
                        isY = true;
                        yp = pcur;
                   } 
                   if(cur.left!=null)
                   {
                    q.add(cur.left);
                    pq.add(cur);
                   }
                   if(cur.right!=null)
                   {
                    q.add(cur.right);
                    pq.add(cur);
                   }
                }
                if(isX && isY)
                {
                    return xp!=yp;
                }
                if(isX || isY)
                return false;
            }
            return false;
    }
}

//tc:O(n)
//sc:O(n)