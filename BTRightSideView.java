// Time Complexity : O(n)
// Space Complexity : O(n/2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None.

import java.util.*;
import javax.swing.tree.TreeNode;

public class BTRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result =new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode node = root;
        if(root==null)
            return result;
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i = 0; i < size; i++)
            {
                node=q.poll();
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            result.add(temp.val);
        }
        return result;
    }
}
