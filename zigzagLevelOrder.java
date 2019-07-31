// Did it run on leetcode: yes

// IDEA: a) This is a BFS. Maintain a stack and push the values at each level.
//       b) Maintain a boolean leftToRight where a node's left value is pushed first before second value, 
//       and when left to right is false, do vice cersa.
//       c) repeat until stack gets empty

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
class zigzagLevelTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> mainList = new ArrayList<List<Integer>>();
        if(root==null) return mainList;
        List<Integer> innerList = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> subStack = new Stack<TreeNode>();
        boolean leftToRight = false;
        innerList.add(root.val); mainList.add(innerList); stack.push(root);
        innerList = new ArrayList<Integer>();
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop(); 
            
            // traversing from right to left
            if(!leftToRight) {
                if(node.right!=null) {
                    subStack.push(node.right);
                    innerList.add(node.right.val);
                }
                if(node.left!=null) {
                    subStack.push(node.left);
                    innerList.add(node.left.val);
                }
            }
            // traversing from left to right
            if(leftToRight) {
                if(node.left!=null) {
                    subStack.push(node.left);
                    innerList.add(node.left.val);
                }
                if(node.right!=null) {
                    subStack.push(node.right);
                    innerList.add(node.right.val);
                }
            }
                // checking if stack is empty and pushing substack value to main stack to repeat cycle
                if(stack.isEmpty()) {
                    if(innerList.size()>0) {
                        stack = subStack;
                        subStack = new Stack<TreeNode>();
                        mainList.add(innerList);
                        innerList = new ArrayList<Integer>();
                        leftToRight = !leftToRight;
                    }
                }
        }    
        return mainList;
        
    }
}

  