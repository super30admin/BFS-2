// Time - O(N)
// Space - O(H)

class Solution {
    int heightX;
    int heightY;
    TreeNode parentX;
    TreeNode parentY;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }
        parentX = null;
        parentY = null;
        
        dfs(root, x, y, 0, null);
                
        return heightX == heightY && parentX != parentY;
    }
    
    private void dfs(TreeNode root, int x, int y, int level, TreeNode parent) {
        if(root == null) {
            return;
        }
        
        if(root.val == x) {
            heightX = level;
            parentX = parent;
        }
        if(root.val == y) {
            heightY = level;
            parentY = parent;
        }
        dfs(root.left, x, y, level + 1, root);
        dfs(root.right, x, y, level + 1, root);
    }
}

// BFS
// Time - O(N)
// Space - O(N)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }
        
        return bfs(root, x, y);
    }
    
    private boolean bfs(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int levelX = 0;
        int levelY = 0;
        int level = 0;
        TreeNode parent = null;  
        
        TreeNode parentX = parent;
        TreeNode parentY = parent;
        
        boolean isSibling  = false;
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0;i<size;i++) {
                TreeNode ele = q.poll();
                
                if(x == ele.val) {
                    levelX = level;
                }
                if(y == ele.val) {
                    levelY = level;
                }
                if(ele.left != null && ele.left.val == x && ele.right!= null && ele.right.val == y) {
                    return false;
                }
                if(ele.left != null && ele.left.val == y && ele.right!= null && ele.right.val == x) {
                    return false;
                }
                if(ele.left != null) {
                    q.add(ele.left);
                }
                if(ele.right != null) {
                    q.add(ele.right);
                }     
                
            }
            
            level++;     
        }
        if( levelX == levelY) {
                return true;
            }
        else {
            return false;
        }
    }
}
