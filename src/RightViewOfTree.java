// Time Complexity:           O(n)
// Space Complexity:          O(h)
// where n is number of nodes in tree, h is height of tree
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}

public class RightViewOfTree {
    private List<Integer> result;

    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        rightSideView(root, 0);
        return result;
    }

    private void rightSideView(TreeNode node, int level) {

        if(node == null) {
            return;
        }

        // NRL
        if(result.size() == level) {
            result.add(node.val);
        }
        rightSideView(node.right, level+1);
        rightSideView(node.left, level+1);

//         // NLR
//         if(result.size() == level) {
//             result.add(node.val);
//         }
//         else {
//             result.set(level, node.val);
//         }

//         rightSideView(node.left, level+1);
//         rightSideView(node.right, level+1);

    }
}


// Time Complexity:           O(n)
// Space Complexity:          O(n)
// ****************************** Using BFS Approach ******************************
//public class RightViewOfTree {
//    public List<Integer> rightSideView(TreeNode root) {
//
//        List<Integer> result = new ArrayList<>();
//
//        if(root == null)
//            return result;
//
//        Queue<TreeNode> q = new LinkedList<>();
//
//        q.add(root);
//
//        while(!q.isEmpty()) {
//            int size = q.size();
//            while(size-- > 0) {
//                TreeNode node = q.remove();
//
//                if(node.left != null) q.add(node.left);                // if left child exists
//                if(node.right != null) q.add(node.right);              // if right child exists
//
//                if(size == 0) {                                        // last element of current level
//                    result.add(node.val);
//                }
//            }
//        }
//
//        return result;
//
//    }
//}
