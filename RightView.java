import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class RightView {

    // TC: O(n) n - number of nodes in a tree
    // SC: O(n) The exact value will be (n/2 + 1). We will be storing the nodes level by level
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i < size; i++) {
                TreeNode temp = queue.poll();
                if(i == size - 1) {
                    result.add(temp.val);
                }

                if(temp.left != null) {
                    queue.add(temp.left);
                }

                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
        }
        return  result;

    }
}
