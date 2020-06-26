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

/**
 * Time: O(n) n-nodes in the tree
 * SPace: O(h) height of the tree
 */
class Solution {
    int parentX = -1,parentY= -2,depthX=-1,depthY=-2,X,Y;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)return false;
        X = x; Y= y;
        helper(root,0);

        if(parentX != parentY && depthX == depthY)return true;
        return false;

    }
    public void helper(TreeNode node, int level){
        if(node == null)return;
        if((node.left !=null && node.left.val == X) || (node.right != null && node.right.val == X)){
            parentX = node.val;
            depthX = level+1;
        }
        if((node.left !=null && node.left.val == Y) || (node.right != null && node.right.val == Y)){
            parentY = node.val;
            depthY = level+1;
        }
        helper(node.left,level+1);
        helper(node.right,level+1);
    }
}

/**
 * BFS:
 * Time: O(n) n-nodes in the tree
 * Space: O(n)
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null)return false;
        boolean Xfound = false,Yfound=false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                TreeNode node= queue.poll();
                if(node.left != null && (node.left.val == x || node.left.val == y)
                        && node.right != null && (node.right.val == x || node.right.val == y))
                    return false;

                if(node.left != null)
                {
                    if(node.left.val == x) Xfound = true;
                    if(node.left.val == y) Yfound = true;
                    queue.offer(node.left);
                }
                if(node.right != null)
                {
                    if(node.right.val == x) Xfound = true;
                    if(node.right.val == y) Yfound = true;
                    queue.offer(node.right);
                }
                size--;
                System.out.println("size: "+size+" X: "+ Xfound+" Y: "+Yfound);
            }
            System.out.println(" size out");
            if(Xfound == true && Yfound == true) return true;
            else if(Xfound == true || Yfound == true) return false;
            else  {Xfound = false; Yfound = false; }
        }
        System.out.println("out");
        return true;
    }
}