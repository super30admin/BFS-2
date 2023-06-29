import java.util.LinkedList;
import java.util.Queue;

public class CousinsinBinaryTreeBFSIterative {

    // BFS - Iterative

        public boolean isCousins(TreeNode root, int x, int y) {

            // Lists declaration
            Queue<TreeNode> nodeQ = new LinkedList<>();
            Queue<TreeNode> parentQ = new LinkedList<>();

            // Lists initialization
            nodeQ.add(root);
            parentQ.add(null);

            TreeNode parentX = null;
            TreeNode parentY = null;

            boolean xIs = false;
            boolean yIs = false;

            // run BFS until the queue of treenodes is empty
            while(!nodeQ.isEmpty()) {

                // level size
                int sizeQ = nodeQ.size();

                // iterate over a level
                for(int i = 0; i < sizeQ; i++) {

                    // pop out the fronts of queues
                    TreeNode popNode = nodeQ.poll();
                    TreeNode popParent = parentQ.poll();

                    // check if popped node matches any of targets
                    if(popNode.val == x) {

                        xIs = true;
                        parentX = popParent;
                    }

                    if(popNode.val == y) {

                        yIs = true;
                        parentY = popParent;
                    }

                    // add non-null children of popped node to queue
                    if(popNode.left != null) {

                        nodeQ.add(popNode.left);
                        parentQ.add(popNode);
                    }

                    if(popNode.right != null) {

                        nodeQ.add(popNode.right);
                        parentQ.add(popNode);
                    }
                }

                // if x and y are found in a level, check they do not have same parents
                if(xIs && yIs) return parentX != parentY;

                // if only x or y is found in a level, other is missing in that level - hence no cousin
                if(xIs || yIs) return false;
            }

            // if no cousins found in BFS run, output false;
            return false;
        }

}

/* Time Complexity = O(N) - traverse all tree nodes
Space Complexity = O(D) = O(N/2) = O(N) - tree diameter */