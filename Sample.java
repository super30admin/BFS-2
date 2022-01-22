 // Time Complexity :O(N)  N isno.of nodes in the tree
 // Space Complexity :O(H) height of the tree.
 // Did this code successfully run on Leetcode :yes
 // Any problem you faced while coding this :no
 //Right side view of the we can get the result using BFS and DFS
 //in DFS we can either start from the right or left
 //if we start from the right will just store the root into the result by comaring the size of the result
 //if size of the result == level where we stand we can add that elemnt.
 //for instance we are at level 0 and the result size is also 0 that means there is no element in the postion 0.
 // if we are starting from the left will follw the sam steps and will override(replace) the values.
 //to replace the values will follw the same condition and check whether our level is == size or not.
 //if not we will replace the element with current elemnt.
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
    List<Integer>  result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
       dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root ,int level){
        if(root == null) return;
        int size = result.size();
        if(size == level){
            result.add(root.val);
        }else{
            result.set(level,root.val);
        }
        
        dfs(root.left,level+1);
        dfs(root.right,level+1);
        // dfs(root.right,level+1);
        // dfs(root.left,level+1);
    }
}
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
    List<Integer>  result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
       dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root ,int level){
        if(root == null) return;
        int size = result.size();
        if(size == level){
            result.add(root.val);
        }
        dfs(root.right,level+1);
        dfs(root.left,level+1);
    }
}


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
 // Time Complexity :O(N)  N isno.of nodes in the tree
 // Space Complexity :O(n) as we are using auxilary data structure Queue.
 // Did this code successfully run on Leetcode :yes
 // Any problem you faced while coding this :no
 //In BFS we will go level by level by adding the elemnts into the queue.
 //We are using queue because it's FIFO.
 //Will get the size of the queue at each level as we need right side view of the tree we will take the last element in the from the current size
 //After popping out the elments from the queue we will add it's children in to the queue.
 //
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode elment = q.poll();
                if(i == size-1){
                result.add(elment.val);
                }
                if(elment.left != null) q.add(elment.left);
                if(elment.right != null) q.add(elment.right);   
            }
          
        }
        return result;
        
    }
}
 // Time Complexity :O(N)  N isno.of nodes in the tree
 // Space Complexity :O(H) H is height of the tree
 // Did this code successfully run on Leetcode :yes
 // Any problem you faced while coding this :no
 //In DFS we are going to maintain 4 global variables to keep tarck on the level and parents of x and y.
 //For recursion we are going to use root to traverse the tree
 //TreeNode Parent as we need to keep track the parents of x and y when evert we found x or y we will add that gloabl parent this is to know whether the parents are distinct or not
 //we are maintaing a localvariable LEVEL to keep tarck on the level as we have a condition that the x and y must be in same level
 // when ever we hiot will check the conditions and will return boolean 
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
    TreeNode x_parent; TreeNode y_parent;
    int x_level; int y_level;
    public boolean isCousins(TreeNode root, int x, int y){
        // if(x_parent != y_parent && x_level == y_level) return true;
        // if(y_parent != x_parent && y_level == x_level) return true;
        // if(x_parent == y_parent && x_level != y_level) return false;
        // if(y_parent == x_parent && y_level != x_level) return false;
        if(root == null) return false;
        dfs(root,null,0,x,y);
        return x_parent != y_parent && x_level == y_level;
    }
    private void dfs(TreeNode root,TreeNode parent,int level,int x, int y){
        if(root == null) return;
            if(root.val == x ){
            x_parent = parent;
            x_level = level;
        }
        if(root.val  == y){
            y_parent = parent;
            y_level = level;
        }
        dfs(root.left,root,level+1,x,y);
        dfs(root.right,root,level+1,x,y);
        
    }
}
 // Time Complexity :O(N)  N isno.of nodes in the tree
 // Space Complexity :O(H) H is height of the tree
 // Did this code successfully run on Leetcode :yes
 // Any problem you faced while coding this :no
 //it's same like the prevous solution instead of taking parent's as TreeNode just took both of them as integers
 //for level intialized the with -1 because it gets failed in test where the inputs are root and it's child
 //we can intialize either of the condition parent or level.
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
    int x_parent; int y_parent;
    int x_level = -1; int y_level = -1;
    public boolean isCousins(TreeNode root, int x, int y){
       if(root == null)return false;
        dfs(root,0,x,y);
        return x_parent != y_parent && x_level == y_level;
    }
    private void dfs(TreeNode root,int level,int x, int y){
        if(root == null) return;
       
       if(root.left != null){
           if(root.left.val == x){
              x_parent = root.val;
               x_level = level;
           }
           else if(root.left.val == y){
              y_parent = root.val;
               y_level = level;
           }
       }
           if(root.right!= null){
           if(root.right.val == x){
              x_parent = root.val;
               x_level = level;
           }
           else if(root.right.val == y){
              y_parent = root.val;
               y_level = level;
           }
       }
        
        dfs(root.left,level+1,x,y);
        dfs(root.right,level+1,x,y);
        
    }
}


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
        boolean x_parent = false;
        boolean y_parent = false;
        Queue <TreeNode> q = new LinkedList<>();
        q.add(root);
        //if(root.val == x || root.val == y) return false;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0;i< size;i++){
                TreeNode element = q.poll();
                //if(element.val == x || element.val == y) return false;
                if(element.left != null) q.add(element.left);
                if(element.right != null) q.add(element.right);
                
                if(element.left != null && element.right != null && element.left.val == x && element.right.val == y) return false;
                if(element.left != null && element.right != null && element.left.val == y && element.right.val == x) return false;
                if(element.val == x){
                    x_parent =true;
                }else if(element.val == y){
                    y_parent =true;
                }
        
                }
                if(x_parent && y_parent) return true;
            if(x_parent || y_parent) return false;
            }
            
       return false;
        
    }
     
}


