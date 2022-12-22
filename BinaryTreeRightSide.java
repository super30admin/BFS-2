import java.util.*;
//BFS solution
//Time Complexity: O(n)
//Space Complexity: O(n) // n/2 which is the leaf node

/*
 * here we create a queue and until its not empty we loop and loop
 * through it and get the last value of that level and store it in result. 
 */
class BinaryTreeRightSide{
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                if(i == size-1){
                    result.add(temp.val);
                }
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right); 
            }
        }
        return result;
    }
}

//DFS Solution (going right)
//Time Complexity: O(n)
//Space Complexity: O(n)

/*
 * call the dfs function for root and add the root if the size is 
 * equal to level, call the right side of root then the left.
 */
 class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int level){
        //base
        if(root == null) return;

        //logic
        if(result.size() == level){
            result.add(root.val);
        }
        dfs(root.right, level+1);
        dfs(root.left, level+1);
    }
}

// DFS Solution (going left)
//Time Complexity: O(n)
//Space Complexity: O(n)

/*
 * move left and if the level has not been traversed we add the
 * element else we replace the element at that level.
 */

class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int level){
        //base
        if(root == null) return;

        //logic
        if(result.size() == level){
            result.add(root.val);
        }
        else    result.set(level, root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}