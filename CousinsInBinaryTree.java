/**
 * Time Complexity -  O(N) where N is the number of nodes in the tree. 
 * Space Complexity - O(N) in worst case (x and y in last row of a completely balanced tree.)
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isFirstVisited = false;
        
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if(cur.val == x || cur.val == y) {
                    if(isFirstVisited == false)
                       isFirstVisited = true; 
                    else
                        return true;  
                }
                else {
                    if(cur.left != null && cur.right != null) //is siblings ?
                        if((cur.left.val == x || cur.left.val == y) && (cur.right.val == x  || cur.right.val == y))
                            return false;
                    if(cur.left != null)
                        queue.add(cur.left);
                    if(cur.right != null)
                        queue.add(cur.right);
                }
            }
            //only node is found in a level.
            if(isFirstVisited == true)
                return false;
        }
        return false;
    }
}
