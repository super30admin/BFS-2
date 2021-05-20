import java.util.*;

public class CousinsOfTheTree {

    public boolean isCousinsBFS(TreeNode root, int x, int y) {
        //TC: O(N) As we are visiting all the elements in the tree. It will be O(N) 
        //SC: O(N) Worst case N number of elements will be inside the quque.
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()) {
            boolean x_found = false; boolean y_found = false;
            int size = queue.size();
            for(int i=0; i< size; i++) {
                TreeNode currentNode = queue.poll();
                if(currentNode.val == x) x_found = true;
                if(currentNode.val == y) y_found = true;
            
                if(currentNode.left != null && currentNode.right != null) { // Checking same parent or not
                    if(currentNode.left.val == x && currentNode.right.val == y) return false;
                    if(currentNode.left.val == y && currentNode.right.val == x) return false;
                }
                
                if(currentNode.left !=null) queue.add(currentNode.left);
                if(currentNode.right !=null) queue.add(currentNode.right);
            }
             if(x_found && y_found) return true;  
            
            if(x_found || y_found) return false; 
        }
        return false;
    }

    int x_height = -1;
    int y_height = -1;
    TreeNode x_parent = null;
    TreeNode y_parent = null;

    public boolean isCousinsDFS(TreeNode root, int x, int y) {
        //TC: O(N) As we are visiting all the elements in the tree. It will be O(N) 
        //SC: O(H) Where H is the height of the tree. In worst case N number of elements will be inside the recursive stack.

        if(root == null) return false;
        dfs(root, 0, null, x, y);
        if(x_height == -1 || y_height == -1){ 
            return false;
        }
        if(x_height == y_height && x_parent != y_parent) return true;
        return false;
    }

    private void dfs(TreeNode node, int height, TreeNode parent, int x, int y) {
        if(node == null) return;
        if(node.val == x){
            x_height = height;
            x_parent = parent;
        } 
        if(node.val == y) {
            y_height = height;
            y_parent = parent;
        } 
        dfs(node.left, height+1, node, x, y);
        dfs(node.right, height+1, node, x, y);
    }

    public static void main(String[] args) {
        CousinsOfTheTree cousins = new CousinsOfTheTree();
        TreeNode sampleNode = new TreeNode().getSampleSix();
        boolean isCousins = cousins.isCousinsDFS(sampleNode, 1, 2);
        System.out.println("isCousins"+ isCousins);
    }
}
