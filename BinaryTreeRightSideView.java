//Time Complexity O(n)
//Space Complexity O(h) stack space of recursive calls
//Leetcode tested

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> visibleValues = new ArrayList<>();
        if (root == null) return visibleValues;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode current = q.remove();
                if(i == size-1){
                    visibleValues.add(current.val);
                }
                if(current.left!=null){
                    q.add(current.left);
                }
                if(current.right!=null){
                    q.add(current.right);
                }
            }
        }
        return visibleValues;
    }

}
