// Time Complexity: o(n)
// Space Complexity: o(h)
// Did it run on leetcode?: Yes

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem1 {
    public List<Integer> rightSideView(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        if( root == null){
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while( !q.isEmpty()){
            int size = q.size();

            for(int i=0; i<size; i++){

                TreeNode curr = q.poll();

                if( i == size -1){
                    list.add(curr.val);
                }

                if( curr.left != null){
                    q.add(curr.left);
                }


                if( curr.right != null){
                    q.add(curr.right);
                }

            }
        }

        return list;

    }
}
