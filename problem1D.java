import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

class binaryTreeRightSideView{
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;

        helper(root, 0);
        
        return result;
    }

    private void helper(TreeNode root, int lvl){
        if(root == null){
            return;
        }
        if(result.size() == lvl){
            result.add(root.val);
        }

        helper(root.right, lvl + 1);
        helper(root.left, lvl + 1);
    }
}

//problem1D. java has O(n) time complexity and O(H) space compelexity