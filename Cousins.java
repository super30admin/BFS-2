/** 
Problem : Find if the given elements are cousins of each other
Did it run on LeetCode : Yes
Time Complexity : O(n), where n is the number of nodes in the tree
Space Complexity: O(n), where n is the number of nodes in the tree

Approach 1: BFS
1. To check if they are cousins, we need to check if they are on the same level, belong to different parents
2. In BFS, we keep a queue, and keep adding the elements to the queue level by level. 
3. While adding elements of each level to the queue, we keep performing the check.

Approach 2 : DFS.
In DFS, we keep track of the parents explicitly. It's just a direct implementation of DFS
*/
//BFS
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
          
            boolean xFound = false;
            boolean yFound = false;
            int size = q.size();
            for(int i = 0; i<size; i++) {
                TreeNode curr = q.poll();
                if(curr.val == x) {
                    xFound = true;
                }
                if(curr.val == y) {
                    yFound = true;
                }
                if(curr.left != null && curr.right != null) {
                    if(curr.left.val == x && curr.right.val == y) {
                        return false;
                    }
                    if(curr.left.val == y && curr.right.val == x) {
                        return false;
                    }
                }
                if(curr.left!=null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            if(xFound && yFound) {
                return true;
            }
        }
        return false;
    }
}


//DFS
class Solution {
    TreeNode xParent, yParent;
    int xDepth, yDepth;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root,0,null,x,y);
        return xParent != yParent && xDepth == yDepth;
    }
    public void dfs(TreeNode root, int level, TreeNode parent, int x, int y) {
        if(root == null) return;
        if(root.val == x) {
            xParent = parent;
            xDepth = level;
        }
        if(root.val == y) {
            yParent = parent;
            yDepth = level;
        }
        dfs(root.left, level + 1, root, x, y);
        dfs(root.right, level +1, root, x, y);
    }
}
