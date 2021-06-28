
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
class BinaryTreeRightSide {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        if(root==null)
            return result;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode cur = q.poll();
                if(i== size - 1)
                {
                    result.add(cur.val);
                }
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
        }
        return result;
    }
}



// time complexity is O(n)
// Space compelxity is O(n)

//DFS:

//      class BinaryTreeRightSide {
//          List<Integer> result = new ArrayList();
//          public List<Integer> rightSideView(TreeNode root) {
//              if(root==null)
//                  return result;
//              dfs(root, 0);
//              return result;
//          }
//          private void dfs(TreeNode root, int depth)
//          {
//              //base
//              if(root==null)
//                  return;
//              if(depth == result.size())
//              {
//                  result.add(root.val);
//              }
//              else
//              {
//                  result.set(depth, root.val);
//              }
//              //logic
//              dfs(root.left,depth + 1);
//              dfs(root.right, depth + 1);
//
//          }
//
//      }

      // time complexity is O(n)
      //Space compelxity is O(h)