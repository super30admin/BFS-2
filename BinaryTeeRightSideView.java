//Time Complexity: O(n)
//Space Complexity: O(h)
import java.util.ArrayList;
import java.util.List;

public class BinaryTeeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, 0, result);
        return result;

    }
    private void helper(TreeNode root, int level, List<Integer> result){
        if(root==null){
            return;
        }
        if(level == result.size()){
            result.add(root.val);
        }
        else{
            result.set(level, root.val);
        }
        helper(root.left, level+1, result);
        helper(root.right, level+1, result);
    }
}
