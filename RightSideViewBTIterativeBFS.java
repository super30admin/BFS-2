import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;

public class RightSideViewBTIterativeBFS {

    //BFS - ITERATIVE - Queue

        public List<Integer> rightSideView(TreeNode root) {

            List<Integer> result = new ArrayList<>();

            // null case
            if(root == null) return result;

            Queue<TreeNode> nodeQ = new LinkedList<>();

            // start queue with the given root in
            nodeQ.add(root);

            // run BFS till queue is empty
            while(!nodeQ.isEmpty()) { // O(N) - determines Time Complexity

                // maintain the size of a level
                int sizeQ = nodeQ.size();

                // loop for a level
                for(int i = 0; i < sizeQ; i++) { // O(D) - determines Space Complexity

                    // pop out a node from queue
                    TreeNode nodeOut = nodeQ.poll();

                    // if the node is the last in a level, add it to result
                /* if we take i == 0, it gives out the first element in each level i.e.,
                Left side view of binary tree */
                    if(i == sizeQ - 1) result.add(nodeOut.val);

                    // add popped out node's children to queue
                    if(nodeOut.left != null) nodeQ.add(nodeOut.left);
                    if(nodeOut.right != null) nodeQ.add(nodeOut.right);
                }
            }
            // output result as queue is empty and every level is covered
            return result;
        }

}

/*
Time Complexity = O(N) = traverse all nodes through queue

Queue is the auxiliary data structure used to implement BFS

Space Complexity = O(D) = D is the tree diameter = maximum size of queue
= O(N) = N/2 leaves in the last level in case of a CBT
*/

