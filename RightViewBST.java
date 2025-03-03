import java.util.ArrayList;
import java.util.List;
//space O(n)
//time Compexity O(n) all the nodes have to be checked
//if at each level only one child is present which is the parent of the next level child.
public class RightViewBST {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        view(root,result,0);
        return result;
   }

    public void view(TreeNode root,List result,int depth){
        if(root==null) return;
        if(depth==result.size())
            result.add(root.val);
        view(root.right,result,depth+1);
        view(root.left,result,depth+1);
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
//BFS
/*
public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if(root == null) return result;

    Queue<TreeNode> q=new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()){
        int size=q.size();
        List<Integer> level = new ArrayList<>();
        for(int i=0;i<size;i++){

            TreeNode curr=q.poll();
            if(i==size-1){
                result.add(curr.val);
            }
            if(curr.left!=null){
                q.add(curr.left);
            }

            if(curr.right!=null){
                q.add(curr.right);
            }
        }
    }

    return result;
}   */
