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

//****COUSINS IN BST-DFS APROACH****
//Time complexity:o(n);
//Space complexity: o(n); space for the recursive stack;
//Leetcode runnable:Y;
//Any doubts:N;

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
    TreeNode x_parent;
    TreeNode y_parent;
    int x_ht;
    int y_ht;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0,x ,y);
        return x_parent!=y_parent && x_ht==y_ht;
    }
    
    private void dfs(TreeNode root, TreeNode parent, int level, int x, int y)
    {
        //Base case
        if(root==null)
        {
            return;
        }
        //Logic
        if(root.val==x)
        {
            x_parent=parent;
            x_ht=level;
            
        }
        if(root.val==y)
        {
            y_parent=parent;
            y_ht=level;
        }
        
        dfs(root.left, root, level+1, x, y);
        
        dfs(root.right, root, level+1, x, y);
    }
}

//****COUSINS IN BST-DFS APROACH****
//Time complexity:o(n);
//Space complexity: o(n); 
//Leetcode runnable:Y;
//Any doubts:N;

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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty())
        {
            int size=q.size();
            boolean x_flag=false;
            boolean y_flag=false;
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                if(curr.val==x) x_flag=true;
                if(curr.val==y) y_flag=true;
                if(curr.left!=null && curr.right!=null)
                {
                    if(curr.left.val==x && curr.right.val==y) return false;
                    if(curr.left.val==y && curr.right.val==x) return false;
                }
                
                if(curr.left!=null)q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(x_flag==true && y_flag==true) return true;
            if(x_flag==true || y_flag==true) return false;
        }
        return false;
        
    }
}
