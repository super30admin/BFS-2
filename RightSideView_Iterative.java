//T.C O(n)
//S.C O(n)
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//BFS approach to add each level to queue and get the last element at each level as right side view
public class RightSideView_Iterative {
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode curr = null;
            Integer rVal = null;
            for(int i=0;i<q.size();i++) {
                curr = q.poll();
                rVal = curr.val;
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null)
                    q.add(curr.right);
            }
            res.add(rVal);
        }
        return res;
    }
}
