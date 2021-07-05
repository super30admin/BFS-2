// Time Complexity : O(n) - n is equal to number of nodes in Tree
// Space Complexity : O(n) - using extra space - Deque 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I was trying to solve with queue, but couln't remove last element, so had to search and learnt about Deque.

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        int x = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        while (!deque.isEmpty()){
            int n = deque.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<n;i++)
            {
                if (x % 2 == 0){
                    TreeNode node = deque.removeLast();
                    temp.add(node.val);
                    if (node.left != null){
                        deque.addFirst(node.left);
                    }
                    if (node.right != null){
                        deque.addFirst(node.right);
                    }
                }
                else{
                    TreeNode node = deque.removeFirst();
                    temp.add(node.val);
                    if (node.right != null){
                        deque.addLast(node.right);
                    } 
                    if (node.left != null){
                        deque.addLast(node.left);
                    }
                }
            }
            x++;
            result.add(temp);
        }
        return result;
    }
}