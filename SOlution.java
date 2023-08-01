//binary-tree-right-side-view
//TC:O(n)
//SC:O(n)
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


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

class SOlution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result=new ArrayList<Integer>();
        if(root==null)
        {
            return new ArrayList<>();
        }
        Queue<TreeNode> q=new LinkedList<>();

        q.add(root);

        while(!q.isEmpty())
        {
            int size=q.size();

            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                if(curr!=null)
                {
                    //last node of that level
                    if(i==size-1)
                    {
                        result.add(curr.val);
                    }
                    //chk if left curr is not null
                    if(curr.left!=null)
                    {
                        q.add(curr.left);
                    }
                    if(curr.right!=null)
                    {
                        q.add(curr.right);
                    }
                }

            }
        }
        return result;
    }
}