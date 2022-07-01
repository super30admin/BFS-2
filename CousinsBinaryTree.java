/*
The following code uses a BFS solution to check whether there are cousins in the binary tree. We initiate a level order
traversal of the tree, and whenever we are at a particular node, we check if its children are the target nodes or not. 
If they are the targets, then we return false, as they are not cousins, and we only continue the level order traveral
as long as all the nodes being checked are already checked for not being siblings.

Did this code run on leetcode: yes
*/
class Solution {
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            boolean flagX = false;
            boolean flagY = false;
            int size = q.size();
            
            for(int i = 0; i < size; i++)
            {
                TreeNode curr = q.poll();
                if(curr.val == x)
                    flagX = true;
                if(curr.val == y)
                    flagY = true;
                //Checking if the targets are siblings
                if(curr.left != null && curr.right != null)
                {   
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
            if(flagX == true && flagY == true)
                return true;
            //If one of the targets was already found on a level, and the other one was not, then we do not have to check further for a cousin
            if(flagX == true || flagY == true)
                return false;
        }
        
        return true;
    }
}