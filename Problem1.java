Time Complexity: O(n)
Space Complexity: O(n)
Ran Successfully on leetcode?: yes

class Solution {
    int x_xparent, x_yparent, y_xparent, y_yparent;
    Queue<TreeNode> q;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(x == root.val || y == root.val) return false;
        q = new LinkedList<>();
        q.add(root);
        bfsHelper(x, y, 0);
        return x_xparent != y_xparent && x_yparent == y_yparent;
    }
    
    private void bfsHelper(int x, int y, int level){
        int size = q.size();
        if(size == 0) return;
        
        while(size > 0){
            TreeNode currNode = q.poll();
            if(currNode.left != null){
                q.add(currNode.left);
                if(x == currNode.left.val){
                   x_xparent = currNode.val;
                    x_yparent = level;
                }
                if(y == currNode.left.val){
                    y_xparent = currNode.val;
                   y_yparent = level;
                }
            }
            if(currNode.right != null){
                q.add(currNode.right);
                if(x == currNode.right.val){
                   x_xparent = currNode.val;
                    x_yparent = level;
                }
                if(y == currNode.right.val){
                    y_xparent = currNode.val;
                    y_yparent = level;
                }
            }
            size--;
        }
        bfsHelper(x, y, level + 1);
    }
}
