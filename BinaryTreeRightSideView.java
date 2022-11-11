
// TC : O(n)
// SC : O(n)

package S30_Codes.BFS_2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Definition for a binary tree node.
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

class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        return levelOrder(root);
    }

    private List<Integer> levelOrder(TreeNode root){
        List<Integer> ans = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Queue<TreeNode> nextQ = new LinkedList<>();

            while(!q.isEmpty()){
                TreeNode node = q.poll();

                if(q.size() == 0)
                    ans.add(node.val);

                if(node.left != null)
                    nextQ.add(node.left);

                if(node.right != null)
                    nextQ.add(node.right);

            }
            q = nextQ;
        }
        return ans;
    }
}