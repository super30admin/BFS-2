package com.leetcode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideVeiw {
    /**
     * Time Complexicity - O(n)
     * Space Complexity  - O(n/2)
     */
    class Solution {
        public List rightSideView(TreeNode root) {
            List ans = new ArrayList();
            if(root ==null)
                return ans;

            int levelOfTree = 0;
            rightView(root , levelOfTree , ans);
            return ans;
        }

        List<Integer> rightView(TreeNode root ,int level ,List<Integer> ans){
            if(root == null)
                return ans;

            if(ans.size() == level)
                ans.add(root.val);

            rightView(root.right, level+1, ans);
            rightView(root.left, level+1, ans);

            return ans;
        }
    }
}
