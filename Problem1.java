//TC - O(N) 
//SC - O(h) recursive stack space
/*
I used dfs and passed on the level as local varibale
at each level I check if there exists no element at that level, I will add it
If there exists, I set the new value
Important point to note is that I traversed pre-order 
*/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Problem1 {
    List<Integer> res;
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        res = new ArrayList<>();
        dfs(root, 1);
        return res;
    }

    private void dfs(TreeNode root, int level) {
        //base
        if(root == null) {
            return;
        }


        //logic
        if(res.size() == level-1) {
            res.add(root.val);
        } else {
            res.set(level-1, root.val);
        }

        dfs(root.left,level+1);
        dfs(root.right, level+1);
    }
}
