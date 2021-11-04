// Binary tree right side view

//Time Complexity=O(n)
//Space Complexity=O(n)

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
    List<Integer> rightView;
    public List<Integer> rightSideView(TreeNode root) {
        
        rightView=new ArrayList<>();
        // dfs(root,0);
        // return rightView;
        
        if(root==null){
            return rightView;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = 0;
        while(!q.isEmpty()){
            
            size = q.size();
            TreeNode curr = new TreeNode();
            
            for(int i=0;i<size;i++){
                
                curr = q.poll();
                
                if(curr.left!=null){
                    q.add(curr.left);
                }
                
                if(curr.right!=null){
                    q.add(curr.right);
                }
                
            }
            rightView.add(curr.val);
        }
        
        return rightView;
    }
    
    private void dfs(TreeNode root, int level){
        if(root==null){
            return;
        }
        
        if(rightView.size()==level){
            rightView.add(root.val);   // NRL
        }
        
        dfs(root.right,level+1);
        dfs(root.left, level+1);
        
    }
    
}

// Binary tree cousins

//Time Complexity=O(n)
//Space Complexity=O(n)

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
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int size=0;
        
        while(!q.isEmpty()){
            boolean xfound=false;
            boolean yfound=false;
            size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && curr.right!=null){
                    if(curr.left.val==x && curr.right.val==y){
                        return false;
                    }
                    if(curr.left.val==y && curr.right.val==x){
                        return false;
                    }
                }
                
                //check curr values
                
                if(curr.val==x){
                    xfound=true;
                }
                
                if(curr.val==y){
                    yfound=true;
                }
                
                
                // next level
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
                
            }
            
            if(xfound&&yfound){
                return true;
            }
            
        }
        return false;
    }
}
