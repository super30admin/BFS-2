import java.util.List;
import java.util.ArrayList;

public class RightSideViewBTRecursiveDFSLeftcallfirst {

    // DFS - Left call first
        List<Integer> result;
        public List<Integer> rightSideView(TreeNode root) {

            this.result = new ArrayList<>();

            leftfirstDFS(root, 0);
            return result;
        }

        private void leftfirstDFS(TreeNode root, int level) {

            //base
            if(root == null) return;

            //logic
            if(result.size() == level) {

                result.add(root.val);
            }
            else{

                result.set(level, root.val); // O(1) - overwrites
            }

            leftfirstDFS(root.left, level+1);
            leftfirstDFS(root.right, level+1);

        }

}

/* Time Complexity = O(N) - traverse all nodes

Space Complexity = O(H) - recursive stack */