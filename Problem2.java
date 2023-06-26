package BFS2;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * While doing BFS we search for x and y and also store their parents and level when found.If the parents are not equal
 * and they are at the same level then they are cousins
 * 
 * Time Complexity : O(n) where n is the no of nodes
 * 
 * 
 * Space Complexity : O(n) since we use a queue
 * 
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : No
 */
public class Problem2 {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode parentX=null;
        TreeNode parentY=null;
        int counter=0;
        int levelX=0;
        int levelY=0;


        Queue <TreeNode> q= new LinkedList<>();
        q.add(root);

        if(root.val==x || root.val==y){
            return false;
        }

        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null){
                    if(curr.left.val==x){
                        parentX=curr;
                        levelX=counter;

                    }
                    else if(curr.left.val==y){
                        parentY=curr;
                        levelY=counter;

                    }
                    
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    if(curr.right.val==x){
                        parentX=curr;
                        levelX=counter;

                    } 
                    else if(curr.right.val==y){
                        parentY=curr;
                        levelY=counter;
                    }
                    
                    
                    q.add(curr.right);
                }

            }
            counter++;

        }
        return(levelX==levelY && parentX!=parentY);

    }
}
