//Problem 1: Binary Tree Right Side view
// Time Complexity :O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No problem


// Your code here along with comments explaining your approach
//1] keep level order nodes in list, add last node(right view) of that list in resultant list, return resultant list
 class Solution {
    List<Integer> li;
    public List<Integer> rightSideView(TreeNode root) {
        // li=new ArrayList<>();
        // if(root==null) return li;
        // Queue<TreeNode> q=new LinkedList<>();
        // q.add(root);
        // int depth=0;
        // while(!q.isEmpty()){
        //     int size=q.size();
        //     List<Integer> temp=new ArrayList<>();
        //     while(size>0){
        //         TreeNode cur=q.poll();
        //             temp.add(cur.val);
                
        //         if(cur.left!=null) q.add(cur.left);
        //         if(cur.right!=null) q.add(cur.right);
        //         size--;
        //     }
        //     depth++;
        //     li.add(temp.get(temp.size()-1));
        // }
        // return li;
        li=new ArrayList<>();
        if(root==null) return li;
        dfs(root, 0);
        return li;
    }
    private void dfs(TreeNode root, int height){
        if(root==null) return;

        if(height==li.size()){
            li.add(root.val);
        }
        else
            li.set(height,root.val);
        
        dfs(root.left, height+1);
        dfs(root.right, height+1);
    }
}
    

    //DFS Approach with height as local Variable
    //keep a List<height, List<>> traverse and add variables, keep height as local 
    //Time : O(n)
    //Space : O(h)
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.res= new ArrayList<>();
        dfs(root, 0); //call from root node
        return res;
    }

    private void dfs(TreeNode root, int height){
        if(root==null) return;

        if(height==res.size()) //chec if height equals size, if yes, there is no arraylist at given height, add it
            res.add(new ArrayList<>());
        dfs(root.left, height+1); //traverse to left node and increment height
        res.get(height).add(root.val); // add value in inorder manner
        dfs(root.right, height+1); //traverse to right node and increment height
    }
}

//Problem 2: Cousins in a binary tree
// Time Complexity :O(n)
// Space Complexity : O(2n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No problem


// Your code here along with comments explaining your approach
//1] maintain 2 queue, always pair child with parent in 2 queue(can be done in 1) whenever u get 2 desired children, check if they have different parents. in the same level
class Solution {
    //maintain 2 queue, parent and child paring
    //TC O(n)
    //SC O(2n)
    // public boolean isCousins(TreeNode root, int x, int y) {
    //     Queue<TreeNode> child= new LinkedList<>();
    //     Queue<TreeNode> parent= new LinkedList<>();
    //     child.add(root);
    //     parent.add(null);
    //     while(!child.isEmpty()){
    //         int size=child.size();

    //         boolean x_Found = false;
    //         boolean y_Found = false;
    //         TreeNode x_Parent = null;
    //         TreeNode y_Parent = null;

    //         for(int i=0;i<size;i++){
    //             TreeNode cur=child.poll();
    //             TreeNode curP= parent.poll();

    //             if(cur.val ==x){
    //                 x_Found=true;
    //                 x_Parent=curP;
    //             }
    //             if(cur.val == y){
    //                 y_Found=true;
    //                 y_Parent=curP;
    //             }

    //             if(cur.left!=null){
    //                 child.add(cur.left);
    //                 parent.add(cur);
    //             }
    //             if(cur.right!=null){
    //                 child.add(cur.right);
    //                 parent.add(cur);
    //             }
    //         }
    //         if(x_Found && y_Found) return x_Parent != y_Parent;
    //         if(x_Found || y_Found) return false;
    //     }
    //     return false;
    // }

    TreeNode x_parent;
    TreeNode y_parent;
    int heightX, heightY;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null) return false;
        dfs(root, x, y, 0, null);

        return heightX==heightY && x_parent != y_parent;
    }

    private void dfs(TreeNode root, int x, int y, int height, TreeNode parent){
        //base
        if(root==null) return;
        //logic
        if(root.val==x){
            heightX=height;
            x_parent=parent;
        }
        if(root.val==y){
            heightY=height;
            y_parent=parent;
        }
        if(x_parent==null || y_parent == null)
            dfs(root.left, x, y, height+1, root);
        if(x_parent==null || y_parent == null)
            dfs(root.right, x, y, height+1, root);
    }
}