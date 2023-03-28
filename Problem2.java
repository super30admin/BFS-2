// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
We add root into the queue. Check at a particular level, if both x and y are present as its children. 
If they are the parents children we return false. Else, we recurse on the left child and right child and keep comparing before entering it into the queue. 
A level and its children are checked before going to the next level. 
 * 
 */


public class Problem2 {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean x_found = false; 
        boolean y_found = false; 
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr.val == x)
                    x_found = true;
                if(curr.val == y)
                    y_found = true; 
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y)
                        return false; 
                    if(curr.left.val == y && curr.right.val == x)
                        return false;
                }
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
            if(x_found && y_found)
                return true; 
            if(x_found || y_found)
                return false;
            }
            return false;
        }
    }
