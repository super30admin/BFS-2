class RightSideView {
  /**
   * Approach - 1 
   * 
   *   Using DFS
   * 
   * Time Complexity: O(n)
   *      -- We have to traverse over all the nodes in the Tree.
   * 
   * Space Complexity: O(logn)
   *      - At any time, we would have the recursive stack, which occupies O(logn) space
   * 
   * Were you able to solve this on leetcode? Yes
   */

  List<Integer> result;
    
  public List<Integer> rightSideView(TreeNode root) {
      result = new ArrayList<>();
      
      traverseTree(root, 0);
      return result;
  }
  
  void traverseTree(TreeNode root, int level){
      if(root == null) { return ; }
      if(level == result.size()){ result.add(root.val); }
      
      traverseTree(root.right, level+1);
      traverseTree(root.left, level+1);
  }

   /**
   * Approach - 2
   * 
   *   Using BFS
   */
}