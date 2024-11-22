import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//bfs
// Time Complexity: O(n)
// Space Complexity: O(n/2)=O(n)

public class problem1 {
    public class TreeNode1 {
        int val;
        TreeNode1 left;
        TreeNode1 right;
        TreeNode1() {}
        TreeNode1(int val) { this.val = val; }
        TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //bfs
    public List<Integer> rightSideView(TreeNode1 root) {

        List<Integer> result = new ArrayList<Integer>();
        if (root==null)
        {
            return  result ;
        }
        Queue<TreeNode1> queue = new LinkedList<TreeNode1>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode1 node = queue.poll();
                if(i==size-1)
                 {
                     result.add(node.val);
                 }
                if (node.left!=null)
                {
                    queue.add(node.left);
                }
                if (node.right!=null)
                {
                    queue.add(node.right);
                }

            }
        }
        return result;
    }
    //Time Complexity: O(N) ; N is the number of nodes in the tree
    // Space Complexity: O(H) ; H is the height of the tree
    //dfs
    List<Integer> result;
    public List<Integer> rightSideViewbfs(TreeNode1 root) {
        result = new ArrayList<>();
        helper(root, 0);
        return result;
    }
    void helper(TreeNode1 node, int depth) {
        //base condition
        if (node == null)
        {
            return;
        }
        //logic
        if(depth==result.size())
        {
            result.add(node.val);
        }

        helper(node.right, depth+1);
        helper(node.left, depth+1);
    }
}
