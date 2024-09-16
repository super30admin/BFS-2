//time complexity:O(n)
//space complexity:O(height of tree)-DFS
//space complexity:O(number of leaf nodes)-BFS
/*Approach 
BFS
-following bfs and adding children of node in the queue
-processing level by level
-taking x_found and y_found variables ,checking next level children being in a level if both of them are x
and y returning false
-returning true if no where false is returned and x_found and y_found is true
DFS
-maintaining parent and level at the same time
-if we found x we will store its level and parents and will do the same for y
-if at the end level of x is same with y but parent is different then we will return true, else false
*/
import java.util.LinkedList;
import java.util.Queue;

public class CousinsInTree{
    public static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
        }
      
//bfs

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){return false;}
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            for(int i = 0; i < size;i++){
                TreeNode curr = q.poll();
                if(curr.val ==  x)x_found = true;
                if(curr.val == y)y_found = true;
                if(curr.left != null && curr.right != null){
                    if(curr.left.val == x && curr.right.val == y)return false;
                    if(curr.left.val == y && curr.right.val == x)return false;
                } 
            if(curr.left != null)q.add(curr.left);
            if(curr.right != null)q.add(curr.right);
            }
            if(x_found && y_found) return true;
        }
        return false;
    }
//dfs

    int x_level; int y_level;
    TreeNode x_parent; TreeNode y_parent;
    public boolean isCousinsdfs(TreeNode root, int x, int y) {
        if(root == null){return false;}
        dfs(root,null,0,x,y);
        return x_parent != y_parent && x_level == y_level;
    }
    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y){
        if(root ==  null){return;}
        if(root.val == x){
            x_level = level;
            x_parent = parent;
        }
        if(root.val == y){
            y_level = level;
            y_parent = parent;
        }
        dfs(root.left, root,level+1,x,y);
        dfs(root.right,root,level+1,x,y);
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.left= new TreeNode(4);
        root.left.right= new TreeNode(3);
        root.right = new TreeNode(5);
        root.right.left=new TreeNode(6);
        root.right.right=new TreeNode(7);
        CousinsInTree obj = new CousinsInTree();
        System.out.println(obj.isCousins(root, 3, 7));
        System.out.println(obj.isCousinsdfs(root, 4, 2));

    }

}