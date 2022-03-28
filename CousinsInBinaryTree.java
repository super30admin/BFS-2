//Time Complexity O(n)
//Space Complexity O(h) stack space of recursive calls
//Leetcode tested
import java.util.ArrayList;
import java.util.List;

public class CousinsInBinaryTree {
    public int xFlag=-1,yFlag=-1;
    public TreeNode xRoot=null,yRoot=null;
    public boolean isCousins(TreeNode root, int x, int y) {
        result = new ArrayList<>();
        traverse(null,root,0,x,y);
        if(xFlag == -1 || yFlag == -1) return false;
        if(xRoot == yRoot) return false;
        return xFlag == yFlag;
    }

    public void traverse(TreeNode parent,TreeNode root,int level,int x,int y){
        if(root == null) return;
        if(root.val == x){
            xRoot=parent;
            xFlag=level;
        }else if(root.val == y){
            yRoot=parent;
            yFlag=level;
        }
        traverse(root,root.left,level+1,x,y);
        traverse(root,root.right,level+1,x,y);
    }

}
