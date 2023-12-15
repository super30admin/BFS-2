import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    //********************** BFS ********************
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size;i++){
                TreeNode curr = q.poll();
                if(i == size - 1){ // if we take i == 0 it will give left side view
                    result.add(curr.val);
                }
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return result;
    }



    public List<Integer> rightSideView1(TreeNode root) {
        //****************DFS *********************/
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        helper(root, 0, result);
        return result;
    }
    private void helper(TreeNode root, int level, List<Integer> result){
        if(root == null) return;

        if(level == result.size()){
            result.add(root.val);
        }
        helper(root.right, level+1, result); //for left side view interchange the two.
        helper(root.left, level+1, result);
    }



    public List<Integer> rightSideView2(TreeNode root) {
        //****************DFS *********************/
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        helper2(root, 0, result);
        return result;
    }
    private void helper2(TreeNode root, int level, List<Integer> result){
        if(root == null) return;

        if(level == result.size()){
            result.add(root.val);
        }else{
            result.set(level,root.val);
        }
        helper2(root.left, level+1, result);
        helper2(root.right, level+1, result);
    }
}
