// Time Complexity : O(n)  // we visit each node once
// Space Complexity : O(h) // recursion stack where h is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: 
// We do a DFS traversal while tracking the parent and depth of both target nodes.  
// If they are found at the same depth but with different parents, they are cousins.  
// Otherwise, they are not cousins.




class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val){
        this.val=val;
    }

    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

}




public class CousinsInBinaryTree {
    TreeNode xpar, ypar;
    int xlvl, ylvl;
    public boolean solve(TreeNode root, int x, int y){
        if(root==null){
            return false;
        }
        xlvl = -1;
        ylvl = -1;
        dfs(root, null, 0, x, y);
        return xpar!=ypar && xlvl == ylvl;
    }
    private void dfs(TreeNode root, TreeNode parent, int lvl, int x, int y){
        if(root==null){
            return;
        }

        if(root.val == x){
            xpar = parent;
            xlvl = lvl;
        }
        if(root.val == y){
            ypar = parent;
            ylvl = lvl;
        }
        dfs(root.left, root, lvl+1, x, y);
        dfs(root.right, root, lvl+1, x, y);
    }

    public static void main(String[]args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        CousinsInBinaryTree ob = new CousinsInBinaryTree();
        System.out.println(ob.solve(root, 4, 5));
        System.out.println(ob.solve(root, 2, 3));
        System.out.println(ob.solve(root, 4, 2));




    }



}
