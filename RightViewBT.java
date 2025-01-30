import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

//Time Complexity : O(n)
// Space Complexity: O(n)

public class RightViewBT {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        return addRElem(root, q, nums);
    }

    public List<Integer> addRElem(TreeNode node, Queue<TreeNode> q,List<Integer> nums ){
        if(node != null){
            q.add(node);
        }
        while(!q.isEmpty()){

            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode root = q.poll();

                if(i == size-1){
                    nums.add(root.val);
                }

                if(root.left != null){
                    q.add(root.left);
                }

                if(root.right != null){
                    q.add(root.right);
                }
            }
        }
        return nums;
    }
}
