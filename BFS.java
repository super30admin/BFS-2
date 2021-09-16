import java.util.*;
public class BFS {
    //time complexity : N
    //space complexity : H (height)
    //did it run on leetcode : yes
    // any doubts : no
    //using BFS
    //https://leetcode.com/problems/binary-tree-right-side-view/submissions/

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null ) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i<size;i++){
                TreeNode curr = q.poll();
            //  if(i==0) -- left size view
                if(i== size-1){                    
                    result.add(curr.val);
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return result;
    }
     //time complexity : N
    //space complexity : H
    //did it run on leetcode : yes
    // any doubts : no
    //DFS
    static List<Integer> result;
    public List<Integer> rightSideViewusingDFS(TreeNode root) {
        result = new ArrayList<>();
        dfs( root,0);
        return result;
    }
    private static void dfs(TreeNode root,int level){
        if(root == null) return ;
        if(result.size()==level){
            result.add(root.val);
        }else{
            result.set(level,root.val);
        }
        dfs(root.left,level+1);
        dfs(root.right, level+1);
    }


     //time complexity : N
    //space complexity : H
    //did it run on leetcode : yes
    // any doubts : no
    //https://leetcode.com/problems/cousins-in-binary-tree/submissions/
    //using dfs
    static TreeNode x_parent;
    static TreeNode y_parent;
    static int xdepth;
    static int ydepth;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        dfs(root,x,y,0,null);
        return x_parent != y_parent && xdepth == ydepth;
    }
    private static void dfs(TreeNode root,int x,int y,int depth,TreeNode parent){
        if(root == null) return;
        if(root.val == x){
            x_parent = parent;
            xdepth = depth;
        }
        if(root.val == y){
            y_parent = parent;
            ydepth = depth;
        }
        dfs(root.left,x,y,depth+1,root);
        dfs(root.right,x,y,depth+1,root);
    }

    //time complexity : N
    //space complexity : N/2
    //did it run on leetcode : yes
    // any doubts : no
    //BFS
    public boolean isCousinsBFS(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            boolean x_found = false;
            boolean y_found = false;
            for(int i =0;i<size;i++){
                TreeNode parent = q.poll();
                if(parent.val == x) x_found = true;
                if(parent.val == y) y_found = true;
                if(parent.left != null && parent.right != null){
                    if(parent.left.val == x && parent.right.val == y) return false;
                    if(parent.right.val == x && parent.left.val == x) return false;
                }
                if(parent.left != null) q.add(parent.left);
                if(parent.right != null) q.add(parent.right);
            }
            if(x_found && y_found) return true;
            if(x_found || y_found) return false;
        }
        return false;
    }

}
