package s30.BFS.BFS2;

import s30.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    private List<Integer> res;

    private int maxHeight;

    // BFS
    //Time Complexity : O(n) iterating all nodes.
    // Space Complexity: O(n/2) at max we'll have all my leaves in queue.
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> storeRight = new ArrayList();

        Queue<TreeNode> level =  new LinkedList();

        if(root == null) return storeRight;

        level.add(root);

        while(!level.isEmpty()){

            int size = level.size();

            while(size > 0){

                TreeNode node = level.poll();

                if(node.left!=null) level.add(node.left);
                if(node.right!= null) level.add(node.right);

                if(size ==1) storeRight.add(node.val);
                size--;
            }

        }

        return storeRight;


//         storeRight =  new ArrayList();
//         maxHeight =0;

//         rightSideViewRec(root,0);

//         return storeRight;

    }


    // Recursive or DFS
    //Time Complexity : O(n) iterating all nodes.
    // Space Complexity: O(h) height of the tree
    public List<Integer> rightSideViewRecSoln(TreeNode root){
         res =  new ArrayList();
         maxHeight =0;

         rightSideViewRec(root,0);

         return res;
    }

    private void rightSideViewRec(TreeNode node,int level){

        //base
        if(node == null) return;

        ++level;
        if(level > maxHeight)
            res.add(node.val);


        maxHeight = Math.max(maxHeight, level);

        //recurse
        rightSideViewRec(node.right, level);
        rightSideViewRec(node.left, level);
    }
    public static void main(String[] args) {

    }
}
