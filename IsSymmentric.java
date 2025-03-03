import java.util.LinkedList;
import java.util.Queue;
//time complexity O(n) , space Complexity O(n) as the tree can go linear
public class IsSymmentric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return false;
        return symmetric(root.left, root.right);
    }

    private boolean symmetric(TreeNode node1, TreeNode node2) {
        if(node1==null && node2==null) {
            return true;
        }
        if(node1==null || node2==null) {
            return false;
        }
        if(node1.val!=node2.val) {
            return false;
        }
        boolean lFlag=symmetric(node1.left, node2.right);
        boolean rFlag=symmetric(node1.right, node2.left);
        return lFlag && rFlag;
    }

  public class TreeNode {
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
}
//iterative time O(n) and space O(n)

/*
public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
        TreeNode t1 = q.poll();
        TreeNode t2 = q.poll();
        if (t1 == null && t2 == null) continue;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        q.add(t1.left);
        q.add(t2.right);
        q.add(t1.right);
        q.add(t2.left);
    }
    return true;
}*/
