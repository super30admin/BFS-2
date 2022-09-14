// Time Complexity: o(n)
// Space Complexity: o(h)
// Did it run on leetcode?: Yes

import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while( !q.isEmpty()){

            int size = q.size();
            boolean xVal = false;
            boolean yVal = false;

            for(int i =0; i<size; i++){

                TreeNode curr = q.poll();

                if( curr.val == x){
                    xVal = true;
                }

                if( curr.val == y){
                    yVal = true;
                }

                if( curr.left != null && curr.right != null){

                    if( (curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x)){
                        return false;
                    }

                }

                if( curr.left != null){
                    q.add( curr.left);
                }

                if( curr.right != null){
                    q.add(curr.right);
                }

            }

            if( xVal== true && yVal == true){
                return true;
            }

            if( ( xVal == true && yVal == false) || ( yVal == true && xVal == false)  ){
                return false;
            }

        }

        return false;
    }

}
