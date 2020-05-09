// Time Complexity : O(N)N=number of elements in tree . 
// Space Complexity : O(N) because we use extra data structure the queue and it is max diameter or width . worst case is full complete tree so O(n/2)=> O(n)
// Did this code successfully run on Leetcode :yes. 

// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//the brute force uses the level order traversal  and with two booleans and two TreeNode pointer to keep track of parents;
//Success
//Details 
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Cousins in Binary Tree.
//Memory Usage: 37.8 MB, less than 7.14% of Java online submissions for Cousins in Binary Tree.

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root ==null)
            return false;
        boolean xFound=false;
        boolean yFound=false;
        Queue<TreeNode> queue= new LinkedList<>();
        queue.add(root);
        TreeNode parentX=null;
        TreeNode parentY=null;
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i=0;i<size;i++){
                TreeNode node= queue.poll();
                if (node.left!=null){
                    if (node.left.val==x){
                        xFound=true;
                        parentX=node;
                    }
                    if (node.left.val==y){
                        yFound=true;
                        parentY=node;
                    }
                    queue.add(node.left);
                }
                if (node.right!=null){
                    if (node.right.val==x){
                        xFound=true;
                        parentX=node;
                    }
                    if (node.right.val==y){
                        yFound=true;
                        parentY=node;
                    }
                    queue.add(node.right);
                }
            }
            if (xFound && yFound && parentX!=parentY)
              return true;
            else if (!xFound && !yFound)
              continue;
            else
                return false;
        }
        return false;
    }
}