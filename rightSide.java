//TC On SC Oh

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class rightSide {
  static int de;
    public static void main(String[] args) {
        //[1,2,3,null,4,null,5]
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=null;
        root.left.right=new TreeNode(4);
        root.right.left=null;
        root.right.right=new TreeNode(5);
        root.right.right.left=new TreeNode(5);
        root.right.right=new TreeNode(5);


      List<Integer> res = rightSideView(root);
        System.out.println(res);


    }





    static List<Integer> re=new ArrayList<>();
    public static List<Integer> rightSideView(TreeNode root) {

        dfs(root,0);
        return re;

    }

    private static void dfs(TreeNode root, int depth) {
        if(root==null)return;
        if (re.size()==depth){
            re.add(root.val);
        }
        dfs(root.right,depth+1);
        dfs(root.left,depth+1);
    }
}
