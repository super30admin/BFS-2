
class Solution {
  // Time Complexity : o(n) n = number of nodes
  // Space Complexity :  o(n) n = number of nodes
  // Did this code successfully run on Leetcode : Yes
  // Any problem you faced while coding this : No

  // Your code here along with comments explaining your approach
  //Approach : level order traversal , take last element at each level
  public List<Integer> rightSideView(TreeNode root) {

      List<Integer> l = new ArrayList<>();
      if(root == null) return l;

      Queue<TreeNode> q = new LinkedList<>();
      q.add(root);

      while(!q.isEmpty()){

          int size = q.size();
          for(int i=0; i<size; i++){
              TreeNode curr = q.poll();

              if(i == size-1){
                  l.add(curr.val);
              }
              if(curr.left!=null) q.add(curr.left);
              if(curr.right!=null) q.add(curr.right);

          }
      }
      return l;
  }

// dfs preorder travel and maintaing level at each node
  public List<Integer> rightSideView(TreeNode root) {

        List<Integer> l = new ArrayList<>();
        if(root == null) return l;

        Stack<Pair<TreeNode, Integer>> s = new Stack<>();
        s.push(new Pair(root, 0));

        while(!s.isEmpty()){

            Pair<TreeNode, Integer> p = s.pop();
            TreeNode currNode = p.getKey();
            int currLevel = p.getValue();

            if(l.size() == currLevel){
                l.add(currNode.val);
            }
            else{
                l.set(currLevel, currNode.val);
            }

            if(currNode.right != null) s.push(new Pair(currNode.right, currLevel+1));
            if(currNode.left != null) s.push(new Pair(currNode.left, currLevel+1));

        }
        return l;
    }
}
