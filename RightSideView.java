import java.util.*;
//BFS:
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(i==size-1){
                    result.add(curr.val);
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }

        }
        return result;
    }

//    DFS:

}
