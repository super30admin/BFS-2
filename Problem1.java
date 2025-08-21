//Time Complexity: O(N), where N is the number of nodes in the tree
//Space Complexity: O(M), where M is the maximum width of the tree

//we use BFS to perform level order traversal and the last element at each level is the rightmost element
//we add the rightmost element of each level to the result list
//and traverse its neighbors

class Solution {
    //BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null)return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr=q.remove();
                if(i==size-1)
                    result.add(curr.val);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
        }
        return result;
    }
}