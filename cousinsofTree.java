// Time Complexity : O(n) where n is number of nodes in the tree
// Space Complexity : O(n) where n is number of nodes in the tree.Actually O(n/2) for the queue when the binary tree is full since at the last level there can be at most n/2 nodes but constant factors are ignored in Big O notation
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Here is the code for finding if two nodes in a binary tree are cousins or not using level order traversal (BFS).
 * we use a queue to perform the level order traversal and keep track of whether we have found the two nodes at the current level. Once we enter the for loop, if both x and y are found within the same iteration of for loop, i.e., at the same i value, then they are siblings with same parent and we return false.
 * If they are not siblings we traverse through the entire level and when we find x value at some node we set flag 1 to true and when we find y value at some node we set flag 2 to true. After the for loop, if both flags are true, then we return true since they are at the same level with different parents. If only one flag is true, then we return false since they are at different levels(as it was given that all nodes have unique values).
 * If none of the flags are true, then we continue to the next level and repeat the same process until we have traversed all levels of the tree. If we exit the while loop, it means we have not found both values in the tree, so we return false.
 */
 
import java.util.LinkedList;
import java.util.Queue;


class cousinsOfTree {
    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> q=new LinkedList<>();
        boolean result;
        q.add(root);
        int level;

        while(!q.isEmpty())
        {
            
            int size=q.size();
            TreeNode currNode=null;
            boolean flag1=false;
            boolean flag2=false;

            for(int i=0;i<size;i++)
            {
                
                currNode=q.poll();

                if(currNode.left!=null && currNode.right!=null)
                {
                    if((currNode.left.val==x&&currNode.right.val==y)||(currNode.left.val==y &&currNode.right.val==x))
                    {
                        return false;
                    }
                }
                if(currNode.left!=null)
                {
                    q.add(currNode.left);
                    if(currNode.left.val==x)
                    {
                        flag1=true;
                    }
                    if(currNode.left.val==y)
                    {
                        flag2=true;
                    }
                }
                if(currNode.right!=null)
                {
                    q.add(currNode.right); 
                    if(currNode.right.val==x)
                    {
                        flag1=true;
                    }
                    if(currNode.right.val==y)
                    {
                        flag2=true;
                    }
                }  

            }
            if(flag1 && flag2)
            {
                return true;
            }
            else if(flag1 ^ flag2)
            {
                return false;
            }

        }
        return false;

       
    }
}