
//https://leetcode.com/problems/binary-tree-right-side-view/
/*BFS - Requirement - only right side of the tree should be visible. The right side will be of first root node.
If the right side is smaller than left than only left side should be visible (First right of left and if that is
null than only left side).
* Steps - Keep a list to add the element & keep a queue to add the current element. If the current element is the
last element on that level than add that element to the list.
*
DFS Right Left - begin traversing from the right side of the tree. Once the size of the result size equals
level add it to the result list

*
DFS Left Right - Only change is that when we encounter another element on the same we replace the element with
the current element.
* */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//BFS Solution
//Time Complexity -O(n) for normal bfs traversal
//Space Complexity - O(n) for a queue storage
public class BinaryTreeRightView {
   /* public List<Integer> rightSideView(TreeNode root) {

        //base
        if(root == null) return  new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (i == size - 1) {
                    result.add(curr.val);
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null)q.add(curr.right);
            }
        }
        return result;
    }
*/
    //Time Complexity - O(n) - traversing through all nodes
    //Space Complexity - O(h) - height of the tree
    //DFS Solution Right Left
 /*  List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
    if(root==null) return Collections.emptyList();
    result=new ArrayList<>();
    dfs(root,0);
    return result;
   }
   private void dfs(TreeNode root, int lvl){
        if(root==null)return;
        if(result.size()==lvl) result.add(root.val);
        dfs(root.right,lvl+1);
        dfs(root.left,lvl+1);
   }*/
//Time Complexity - O(n) - traversing through all nodes
   //Space Complexity - O(h) - height of the tree
   //DFS Solution Left Right
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        //base
        if(root==null) return Collections.emptyList();
        result=new ArrayList<>();
        dfs(root,0);
        return result;
    }
    private void  dfs(TreeNode root, int lvl){
        if(root==null) return;
        if(result.size()==lvl) result.add(root.val);
        else result.set(lvl,root.val);
        dfs(root.left,lvl+1);
        dfs(root.right,lvl+1);

    }

}
