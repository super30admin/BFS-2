          // Binary Tree Right Side View

// Time Complexity : O(n)  .. n = number of nodes.
// Space Complexity : O(2^h)  .. h = height of tree.

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList();
        Queue<TreeNode> q = new LinkedList();

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> newList = new ArrayList();
            for(int i=0;i<size;i++){
                TreeNode node = q.remove();
                if(node == null)
                    continue;
                newList.add(node.val); 
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
            if(newList.size() == 0)
                continue;
            else list.add(newList.get(newList.size()-1));
        }
        return list;
    }
}

          // Cousins in Binary Tree

// Time Complexity : O(n)  .. n = number of nodes.
// Space Complexity : O(2^h)  .. h = height of tree.

class Solution {

    int xParent = -1;
    int yParent = -1;
    int xDepth = -1;
    int yDepth = -1;


    public void traversal(TreeNode root, int x, int y){
        int depth = 0;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()){
            if(xDepth != -1 && yDepth != -1)
                break;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode parent = q.remove();
                if(parent.left != null){
                    q.add(parent.left);
                    if(parent.left.val == x){
                        xParent = parent.val;
                        xDepth = depth + 1;
                    }
                        
                    if(parent.left.val == y){
                        yParent = parent.val;
                        yDepth = depth + 1;
                    }
                        
                }
                if(parent.right != null){
                    q.add(parent.right);
                    if(parent.right.val == x){
                        xParent = parent.val;
                        xDepth = depth + 1;
                    }
                    if(parent.right.val == y){
                        yParent = parent.val;
                        yDepth = depth + 1;
                    }
                }
            }
            depth++;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        
        traversal(root, x, y);
        if(xParent == -1 || yParent == -1)
            return false;
        return xParent != yParent && xDepth == yDepth;

    }
}
