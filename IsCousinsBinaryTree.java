import java.util.*;

class IsCousinBinaryTree {
    public class TreeNode {
        int val;
        IsCousinBinaryTree.TreeNode left;
        IsCousinBinaryTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, PreorderInorder.TreeNode left, PreorderInorder.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    TreeNode x_parent,y_parent;
    int x_level,y_level;
    public boolean isCousinsBFS(TreeNode root, int x, int y) {
        /*
        
        TC: O(n)
        SC: O(Height) -> O(n) , the tree can be skewed as well
        
        */
        if(root==null) return false;

        dfs(root,x,y,0,null);

        return x_parent != y_parent && x_level == y_level;
    }

    private void dfs(TreeNode root,int x,int y,int level, TreeNode parent){
        if(root==null) return;

        if(root.val==x){
            x_parent=parent;
            x_level=level;
        }

        if(root.val==y){
            y_parent=parent;
            y_level=level;
        }
        dfs(root.left,x,y,level+1,root);
        dfs(root.right,x,y,level+1,root);
    }


    public boolean isCousinsDFS(TreeNode root, int x, int y) {
        /*
        
        TC: O(n)
        SC: O(n) 
        
        */
        if(root==null) return false;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size=q.size();
            boolean x_found=false,y_found=false;
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();

                if(curr.val==x){
                    x_found=true;
                }
                if(curr.val==y){
                    y_found=true;
                }
                if(curr.left!=null && curr.right!=null &&
                        ((curr.left.val==x && curr.right.val==y) ||
                                (curr.right.val==x && curr.left.val==y)) ){
                    return false;
                }

                if(curr.left!=null)
                    q.add(curr.left);

                if(curr.right!=null)
                    q.add(curr.right);

                if(x_found==true && y_found==true){
                    return true;
                }

            }

            if(x_found==true || y_found==true){
                return false;
            }
        }
        return false;
    }

}