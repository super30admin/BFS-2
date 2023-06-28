// Time Complexity : O(n) where n is the number of nodes
// Space Complexity :O(n) where n is the number of nodes
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
import java.util.LinkedList;
import java.util.Queue;

class Cousins {
    class NodePair{
        TreeNode current;
        TreeNode parent;
    }

    private Queue<NodePair> q;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        this.q = new LinkedList<>();

        NodePair np = new NodePair();
        np.current = root;
        np.parent = null;
        q.add(np);

        return bfs(1, x, y);
    }

    public boolean bfs(int level, int x, int y){

        while(!q.isEmpty()){
            boolean foundX = false;
            boolean foundY = false;
            TreeNode xParent = null;
            TreeNode yParent = null;

            for(int i =0; i < level; i++){
                NodePair np = q.poll();
                TreeNode root = np.current;
                TreeNode parent = np.parent;

                if(root.left != null){
                    NodePair npl = new NodePair();
                    npl.current = root.left;
                    npl.parent = root;
                    q.add(npl);
                }
                if(root.right != null){
                    NodePair npr = new NodePair();
                    npr.current = root.right;
                    npr.parent = root;
                    q.add(npr);
                }
                if(root.val == x){
                    foundX = true;
                    xParent = parent;
                }
                if(root.val == y){
                    foundY = true;
                    yParent = parent;
                }
            }

            if(foundX && foundY) {
                return xParent!= yParent;
            }
            if(foundX || foundY){
                return false;
            }
            level = q.size();
        }
        return false;
    }
}