//****RIGHT SIDE VIEW OF A BINARY SEARCH TREE- BFS****

//Time complexity-o(n);
//Space complexity-O(d); d is diameter of tree;
//Leetcode runnable: Y;
//Any doubts: N;
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
    public List<Integer> rightSideView(TreeNode root) {
        int x=0;
        
        //Result declaration
        List<Integer> ans=new ArrayList<>();
        //Queue for bfs
        Queue<TreeNode> q=new LinkedList<>();
        //null case
        if(root==null) return ans;
        
        //add root to the queue
        q.add(root);
        //processing the queue
        while(!q.isEmpty())
        {
            
            //size consideration
            int size=q.size();
            
            for(int i=0;i<size;i++)
            {
                TreeNode curr= q.poll();
                x=curr.val;
                
                //got ot left and right side
                
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            ans.add(x);
            
        }
        //returning the result
        return ans;
        
    }
}

//****RIGHT SIDE VIEW OF A BINARY SEARCH TREE- DFS****

//Time complexity-o(N);
//Space complexity-O(H);
//Leetcode runnable: Y;
//Any doubts: N;

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
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result=new ArrayList<>();
        if(root==null) return result;
        dfs(root, 0);
            return result;
        
    }
    
    private void dfs(TreeNode root, int level)
    {
        int x=0;
        //base case
        if(root==null)
        {
            return;
        }
        
        //logic
        if(level==result.size())
        {
            result.add(root.val);
        }
        else
        {
            result.set(level, root.val);
        }
        
        //go for left and then right
        dfs(root.left,level+1);
        dfs(root.right, level+1);
    }
}
