import java.util.ArrayList;
import java.util.List;

public class RightSideViewBTRecursiveDFS {

    // DFS - Recursive - Right call first

        List<Integer> result;
        public List<Integer> rightSideView(TreeNode root) {

            this.result = new ArrayList<>();

            rightfirstDFS(root, 0);
            return result;
        }

        private void rightfirstDFS(TreeNode root, int level) {

            //base
            if(root == null) return;

            //logic
            if(result.size() == level) {

                result.add(root.val);
            }

            rightfirstDFS(root.right, level+1);
            rightfirstDFS(root.left, level+1);

        }

}

/* Time Complexity = O(N) - traverse all nodes
Space Complexity = O(H) - recursive stack */


