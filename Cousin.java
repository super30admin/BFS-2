/**
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
// nope

// Your code here along with comments explaining your approach
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> qu = new LinkedList<>();
        TreeNode xParent = null;
        TreeNode yParent = null;

        if(root != null)
            qu.offer(root);

        //doing bfs level order to see if cousins.
        while(!qu.isEmpty()){
            LinkedList<TreeNode> temp  = new LinkedList<>();
            //go over each level.
            while(!qu.isEmpty()){
                TreeNode node = qu.poll();
                //look left.
                if(node.left != null){
                    temp.add(node.left);

                    //if any node found set x or y parent respectively.
                    if(node.left.val == x)
                        xParent = node;
                    else if(node.left.val == y)
                        yParent = node;
                }
                //look right.
                if(node.right != null){
                    temp.add(node.right);

                    //if any node found set x or y parent respectively.
                    if(node.right.val == x)
                        xParent = node;
                    else if(node.right.val == y)
                        yParent = node;
                }
            }
            //if any node found break.
            if(xParent != null || yParent != null)
                break;
            qu.addAll(temp);
        }
        //if both nodes found, then can be cousins if parents not same.
        if((xParent != null && yParent != null) &&
           (xParent != yParent))
            return true;

        return false;
    }
}
