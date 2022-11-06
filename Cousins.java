package s30.BFS.BFS2;

import s30.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Cousins {
    private int x,y, hx, hy;
    private TreeNode parentX, parentY;


    //BFS
    // Time Complexity O(n) iterating all nodes in worst case
    // Space Complexity O(n/2) having all the leaf nodes in the queue.
    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<TreeNode> level= new LinkedList();

        level.add(root);
        TreeNode p = null;

        while(!level.isEmpty()){
            int size = level.size();

            while(size >0){
                TreeNode node = level.poll();

                if(node.left !=null){
                    if(node.left.val ==x || node.left.val == y ){
                        if(p == node) return false;
                        if(p !=null && p != node) return true;
                        p = node;
                    }
                    level.add(node.left);
                }
                if(node.right !=null){
                    if(node.right.val ==x || node.right.val == y ){
                        if(p == node) return false;
                        if(p !=null && p != node) return true;
                        p = node;
                    }
                    level.add(node.right);
                }

                --size;
            }

            if(p!=null) return false;

        }

        return false;


//         this.x = x;
//         this.y= y;
//         hx =0;
//         hy=-1;
//         parentX= null;
//         parentY = null;

//         isCousins(root,null, 0);

//         return hx==hy;
    }

    //DFS or recursive stack
    // Time Complexity: O(n)
    // Space Complexity : O(h)
    public boolean isCousinsRec(TreeNode root, int x , int y){
         this.x = x;
         this.y= y;
         hx =0;
         hy=-1;
         parentX= null;
         parentY = null;

         isCousins(root,null, 0);

         return hx==hy;
    }



    private void isCousins(TreeNode node,TreeNode parent, int level){

        //base
        if(node == null) return;

        if(node.val == x) {
            if(parent != parentY){
                hx = level;
                parentX = parent;
            }
            return;
        }

        if(node.val == y){
            if(parent != parentX){
                hy= level;
                parentY = parent;
            }

            return;
        }


        isCousins(node.left,node, level+1);
        isCousins(node.right, node,level+1);


    }
    public static void main(String[] args) {

    }
}
