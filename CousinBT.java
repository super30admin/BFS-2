
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


public class CousinBT {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        int n1p;
        int n2p;

        int level1;
        int level2;

        int x;
        int y;

        public boolean isCousins(TreeNode root, int x, int y) {

            this.x = x;
            this.y = y;

            BFS(root, 0, 0);

            if(level1 == level2 && n1p != n2p)
            {
                return true;
            }
            return false;
        }

        private void BFS(TreeNode node, int level, int parent){

            Queue <TreeNode> q =  new LinkedList<>();
            q.add(node);

            while(!q.isEmpty()){
                Queue <TreeNode> qt =  new LinkedList<>();


                while(!q.isEmpty()){
                    TreeNode nodeT = q.poll();

                    if(nodeT.left == x && nodeT.right == y){
                        n1p  = 1;
                        n2p = 1;
                        level1 = level;
                        level2 = level;
                        return;
                    }

                    if(nodeT.left.val == x){
                        n1p = nodeT;
                        level1 =  level;
                        return;
                    }
                    if(nodeT.right == y){
                        n2p = nodeT;
                        level2  = level;
                        return;
                    }

                    qt.add(node.left);
                    qt.add(node.right);
                }
            }



      /* DFS
      if(node == null){
          return;
      }



      if(node.val == x){
          level1 = level;
          n1p = parent;
          return;
      }
      if(node.val == y){
        level2 = level;
        n2p = parent;
          return;
      }

      DFS(node.left , level + 1, node.val);
      DFS(node.right , level + 1, node.val);

      */

        }
    }
