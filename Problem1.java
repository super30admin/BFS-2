
//TimeComplexity  : O(n)
//Space Complexity : O(n)
// Passed all Test cases on Leetcode : Yes
// Any issues faced while executing the code : No
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem1 {
    public class TreeNode {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(! q.isEmpty()){
            int size = q.size();
            TreeNode popped = null;
            for (int i=0;i< size;i++){
                popped = q.poll();
                if(popped.left != null){
                    q.add(popped.left);
                }
                if(popped.right != null){
                    q.add(popped.right);
                }

            }
            res.add(popped.val);

        }
        return res;

    }
}
