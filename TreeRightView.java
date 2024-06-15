//Time Complexity: O(n)
//Space Complexity: O(h)
import java.util.*;
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
public class TreeRightView {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root)
    {
        result=new ArrayList<>();
        dfs(root,0);
        return result;
    }
    public void dfs(TreeNode root, int level)
    {
        if(root==null)
        {
            return;
        }
        if(level== result.size())
        {
            result.add(root.val);
        }
        else
        {
            result.set(level,root.val);
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        TreeRightView treeRightView = new TreeRightView();
        System.out.println(treeRightView.rightSideView(root));
    }
}
