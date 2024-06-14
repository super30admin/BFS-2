/* 
    LC - 993. Cousins in Binary Tree
    TC - o(n)
    SC - o(n) - denotes the queue size
*/

// BFS approach

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }
        boolean xFound = false, yFound = false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i=0; i<len; i++) {
                TreeNode curr = q.poll();
                if(curr.val == x) {
                    xFound = true;
                }
                if(curr.val == y) {
                    yFound = true;
                }
                if(curr.left !=null && curr.right != null) {
                    if(curr.left.val == x && curr.right.val == y) {
                        return false;
                    }
                    if(curr.left.val == y && curr.right.val == x) {
                        return false;
                    }
                }
                if(curr.left != null) {
                    q.add(curr.left);
                }
                if(curr.right != null) {
                    q.add(curr.right);
                }
            }
            if(xFound == true && yFound == true) {
                return true;
            }
            if(xFound == true || yFound == true) {
                return false;
            }
        }
        return true;
    }
}

// DFS Approach

/* 
    TC - o(n)
    SC - o(h) - height of the tree
*/

class Solution {
    TreeNode xParent, yParent;
    int xLvl, yLvl;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }
        dfs(root, 0, null, x, y);
        return (xLvl == yLvl) && (xParent != yParent);
    }
    public void dfs(TreeNode root, int lvl, TreeNode parent, int x, int y) {
        if(root == null) {
            return;
        }
        if(root.val == x) {
            xParent = parent;
            xLvl = lvl;
        }
        if(root.val == y) {
            yParent = parent;
            yLvl = lvl;
        }
        dfs(root.left, lvl+1, root, x, y);
        dfs(root.right, lvl+1, root, x, y);
    }
}