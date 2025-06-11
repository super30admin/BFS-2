//Solved successfully on leetcode and faced no issues
//Time complexity : O(n) Space complexity : O(h)

class Solution {
    //DFS Approach
    TreeNode xparent ;
    TreeNode yparent;
    int xlevel;
    int ylevel;
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root , null , 0 , x , y); //initial element doesn't have any parent - so null is passed
        return xlevel == ylevel && xparent!=yparent;

    }
    private void dfs(TreeNode root , TreeNode currentparent , int currentlevel , int x , int y){
        if(root == null){return;}
        if(root.val == x){
            xparent = currentparent;
            xlevel = currentlevel;
        }
        if(root.val == y){
            yparent = currentparent;
            ylevel = currentlevel;
        }
        dfs(root.left , root , currentlevel + 1 , x , y);
        dfs(root.right , root , currentlevel + 1 , x , y);
    }




    //BFS Approach
    // public boolean isCousins(TreeNode root, int x, int y) {
    //     if(root == null){return false;} //tree does not have any nodes , nothing to compare
    //     Queue<TreeNode>queue = new LinkedList<>();
    //     //Push root into queue\
    //     queue.add(root);
    //     //start our bfs
    //     while(!queue.isEmpty()){
    //         int queuesize = queue.size();
    //         boolean xfound = false;
    //         boolean yfound = false;
    //         for(int i = 0 ; i < queuesize ; i++){
    //             //remove root from queue and store in cnode
    //             TreeNode cnode = queue.remove();
    //             //return false if left and right are x,y and vice versa as they r siblings
    //             if(cnode.left!=null && cnode.right!=null){
    //                 if(cnode.left.val == x && cnode.right.val == y || cnode.left.val == y || cnode.right.val == x){
    //                     return false;
    //                 }

    //             }
    //             if(cnode.val == x){xfound = true;}
    //             if(cnode.val == y){yfound = true;}
    //             //process children
    //             if(cnode.left!=null){queue.add(cnode.left);}
    //             if(cnode.right!=null){queue.add(cnode.right);}


    //         }
    //          if (xfound && yfound) return true;  // Both found at same level and not siblings

    //     }
    //     return false;

        
    // }
}