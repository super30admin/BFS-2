import java.util.LinkedList;
import java.util.Queue;

public class CousinsinBinaryTreeBFSIterativeConditional {

    // BFS - Iterative - Conditional

        public boolean isCousins(TreeNode root, int x, int y) {

            // Lists declaration
            Queue<TreeNode> nodeQ = new LinkedList<>();

            // Lists initialization
            nodeQ.add(root);

            boolean xIs = false;
            boolean yIs = false;

            // run BFS until the queue of treenodes is empty
            while(!nodeQ.isEmpty()) {

                // level size
                int sizeQ = nodeQ.size();

                // iterate over a level
                for(int i = 0; i < sizeQ; i++) {

                    // pop out the fronts of queue
                    TreeNode popNode = nodeQ.poll();

                    // check if popped node matches any of targets
                    if(popNode.val == x) {

                        xIs = true;
                    }

                    if(popNode.val == y) {

                        yIs = true;
                    }

                    // checking if x, y are siblings
                    if(popNode.left != null && popNode.right != null) {

                        if(popNode.left.val == x && popNode.right.val == y) return false;
                        if(popNode.right.val == x && popNode.left.val == y) return false;

                    }

                    // add non-null children of popped node to queue
                    if(popNode.left != null) {

                        nodeQ.add(popNode.left);
                    }

                    if(popNode.right != null) {

                        nodeQ.add(popNode.right);
                    }
                }

                // if x and y are found in a level
                if(xIs && yIs) return true;

                // if only x or y is found in a level, other is missing in that level - hence no cousin
                if(xIs || yIs) return false;
            }

            // if no cousins found in BFS run, output false;
            return false;
        }

}

/* Time Complexity = O(N) - traverse all tree nodes
Space Complexity = O(D) = O(N/2) = O(N) - tree diameter

Complexities remain the same asymptotically as when used a parent queue.
But this is optimized in the sense that only one queue is used instead of two queues, saving space.
*/