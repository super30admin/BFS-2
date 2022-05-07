// Time Complexity :O(N)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideViewDFS {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null){
            return result;
        }

        dfs(root,0);

        return result;
    }

    private void dfs(TreeNode root, int level){
        //base
        if(root == null){
            return;
        }

        //logic

        if(level == result.size()){
            result.add(root.val);
        }

        dfs(root.right, level + 1);
        dfs(root.left, level + 1);

    }
}
