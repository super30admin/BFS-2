// --> Time: O(n), Space: O(n)


import java.util.*;

public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        Stack<TreeNode> st = new Stack<>();
        Stack<TreeNode> parentSt = new Stack<>();
        Stack<Integer> levelSt = new Stack<>();

        st.push(root);
        parentSt.push(null);
        levelSt.push(0);

        int x_level=-1, y_level=-1;
        TreeNode x_parent=null, y_parent=null;

        while(!st.isEmpty()) {
            TreeNode curr = st.pop();
            TreeNode parent = parentSt.pop();

            int level = levelSt.pop();

            if(curr.val == x) {
                x_level = level;
                x_parent = parent;
            }

            if(curr.val == y) {
                y_level = level;
                y_parent = parent;
            }

            if(curr.left != null) {
                st.push(curr.left);
                parentSt.push(curr);
                levelSt.push(level+1);
            }
            if(curr.right != null) {
                st.push(curr.right);
                parentSt.push(curr);
                levelSt.push(level+1);
            }
        }
        return x_level == y_level && x_parent != y_parent;
    }
    
}
