import java.util.LinkedList;
import java.util.Queue;

public class IsCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        //space O(n)  as the x,y can be at leaf nodes ,level at which is n/2 nodes exist
        // time Compexity O(n) all the nodes have to be checked for x,y in worest case senario.
        q.add(root);
        while(!q.isEmpty()){
            boolean isXChildfound = false;
            boolean isYChildfound  = false;
            int count=q.size();
            for(int i=0;i<count;i++){
                TreeNode currNode=q.poll();
                if(currNode.val==x) isXChildfound= true;
                if(currNode.val==y) isYChildfound =true;
                if(currNode.left!=null && currNode.right!=null){
                    if(currNode.left.val==x && currNode.right.val==y) return false;
                    if(currNode.left.val==y && currNode.right.val==x) return false;
                }

                if(currNode.left!=null) q.add(currNode.left);
                if(currNode.right!=null) q.add(currNode.right);

            }
            if(isXChildfound  && isYChildfound ) return true;
        }

        return false;
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
