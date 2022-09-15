/*
Time Complexity: O(N)
Space Complexity: O(2^h) width of the tree at the worst case it is 2^h where h is the height of the tree indexed from 0
Using BFS checking each time while polling for sibling condition
Checking at end of each level for same height condition
*/
import java.util.*;
class Solution {
    
    public boolean isCousins(TreeNode root, int x, int y) {
    Queue<TreeNode> q=new LinkedList<TreeNode>();
    boolean xv=false;;
    boolean yv=false;
        q.add(root);
        while(!q.isEmpty()){
            int length=q.size();
            for(int i=0;i<length;i++){
                TreeNode current=q.poll();
                if(current.left!=null){
                    q.add(current.left);
                    if(current.left.val==x){
                    xv=true;
                    }
                    if(current.left.val==y){
                    yv=true;
                    }
                }
                if(current.right!=null){
                    q.add(current.right);
                    if(current.right.val==y){
                    yv=true;
                    }
                        if(current.right.val==x){
                    xv=true;
                    }
                }
                if(current.left!=null&&current.right!=null){
                    if(current.left.val==x&&current.right.val==y||current.left.val==y&&current.right.val==x){
                        return false;
                    }
                }
            }
            if(xv==true&&yv==true){
                return true;
            }
            if(xv==true&&yv==false||yv==true&&xv==false){
                return false;
            }
        }
        return false;
    }
}