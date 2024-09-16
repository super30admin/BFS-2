// Did it run on leetcode: yes

// IDEA:a) This is a BFS. Maintain a stack and push the values at each level.
//      b) Track the level (1,2,3, etc) at each phase, and if either X or Y is found, store it's level and its parent node.
//      c) Again if value other than the already found value is identified, compare it with the stored level & parent node  return result.

// Time Complexity: o(n)
// space Complexity: o(n)


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class isCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null || root.val==x || root.val==y) return false;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> subStack = new Stack<TreeNode>();
        
        TreeNode parentNode = null;
        int level = 2;
        int foundLevel = -1;
        stack.push(root);
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop(); 
            if(node.left!=null) {
                    if(node.left.val==x || node.left.val==y) {
                    if(foundLevel>0) {
                        if(level == foundLevel && node!=parentNode) {
                            return true;
                        }
                        else return false;
                    }
                    else {
                        parentNode = node;
                        foundLevel = level;
                    }
                }
                subStack.push(node.left);
            }
            
             if(node.right!=null) {
                    if(node.right.val==x || node.right.val==y) {
                    if(foundLevel>0) {
                        if(level == foundLevel && node!=parentNode) {
                            return true;
                        }
                        else return false;
                    }
                    else {
                        parentNode = node;
                        foundLevel = level;
                    }
                }
                subStack.push(node.right);
            }
            
            if(stack.isEmpty()) {
                    if(subStack.size()>0) {
                        stack = subStack;
                        subStack = new Stack<TreeNode>();
                        level++;
                    }
                }
        }
        
        return false;
    }
}