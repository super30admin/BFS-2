import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TC: O(n)
//SC: O(n)
class rightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                TreeNode curr = q.poll();
                //We are adding last element of queue in each level which would be visible to right side
                if(i == size-1){
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
}