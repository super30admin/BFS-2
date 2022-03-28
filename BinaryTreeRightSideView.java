// Time Complexity : O(V+E) ~ BFS traversal visiting all the edges; 
// Space Complexity : O(n) ~ Any point the last row of tree will have Max of O(n/2) +1 nodes.
// 1. Storing the elements in queue. 2. Storing in sublist.
// Did this code successfully run on Leetcode : Yes; (https://leetcode.com/submissions/detail/668929526/)
// Any problem you faced while coding this : No;
// My Notes : Traverse from the right child to left in level order traversal. Then remove the first item from the list.

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){return new ArrayList<>();}
        List<Integer> result = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> subList = new ArrayList<>();
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.right!=null){queue.add(node.right);}
                if(node.left!=null){queue.add(node.left);}
                subList.add(node.val);
            }
            // Add the first items of the list.
            result.add(subList.get(0));
            // clear the sublist after adding the first element
            subList.clear();
        }
        //System.out.println("Result : "+result);
        return result;
    }
}