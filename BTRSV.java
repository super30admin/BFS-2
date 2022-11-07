
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


public class BTRSV {
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
        public List<Integer> list ;
        public List<Integer> rightSideView(TreeNode root) {

            list = new ArrayList<>();
            if(root != null)
                rightSideViewR(root,0);
            return list;
        }

        private void rightSideViewR(TreeNode node, int level){

            Queue <TreeNode> q = new LinkedList<>();
            q.add(node);

            while(!q.isEmpty()){
                Queue <TreeNode> qt = new LinkedList<>();

                while(!q.isEmpty()){
                    TreeNode nodeT = q.poll();
                    if(level == list.size()){
                        list.add(nodeT.val);
                    }
                    if(nodeT.right != null){
                        qt.add(nodeT.right);
                    }
                    if(nodeT.left != null){
                        qt.add(nodeT.left);
                    }
                }
                q = qt;
                level++;
            }


        /*
        if(node == null){
            return;
        }
        if(list.size() == level){
            list.add(node.val);
        }
        rightSideViewR(node.right, level + 1);
        rightSideViewR(node.left, level + 1);

        */
        }
    }