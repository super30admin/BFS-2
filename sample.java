import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Binary Tree Right Side View
//Time Complexity : O(N)
//Space Complexity : O(H)

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

class Solution {
    private ArrayList<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                //save the node is curr
                TreeNode curr = q.poll();
                //if curr is last node in the queue add it to result
                if(i == size-1) result.add(curr.val);
                //else add its child
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
        }
        return result;
    }
}

//Cousins in Binary Tree
//Time Complexity : O(N)
//Space Complexity : O(H)
class Solution1 {
    public boolean isCousins(TreeNode root, int x, int y) {
       if(root==null) return false;
       Queue<TreeNode> q= new LinkedList<>();
       q.add(root);
       while(!q.isEmpty()){
           int size=q.size();
           //take two boolean variables for found or not found
           boolean x_found=false;
           boolean y_found=false;
           for(int i = 0; i < size; i++){
                //save the node is curr
               TreeNode curr = q.poll();
               //if it is equal to x or y make then true
               if(curr.val==x) x_found=true;
               if(curr.val==y) y_found=true;
               //move forward if nodes are still there
               if(curr.left!=null && curr.right!=null){
                   //if left=x and right=y or vice verse return false
                   if(curr.left.val==x && curr.right.val==y) return false;
                   if(curr.left.val==y && curr.right.val==x) return false;
               }
               //add to queue
               if(curr.left!=null) q.add(curr.left);
               if(curr.right!=null) q.add(curr.right);
           }
           
           if(x_found && y_found) return true;
       }
       return false; 
    }
}