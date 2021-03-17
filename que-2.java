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
    public List<Integer> rightSideView(TreeNode root) {
        // Java program to print right view of Binary

        List<Integer> list = new ArrayList<>();


		if (root == null)
			return list;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			// number of nodes at current level
			int n = queue.size();
            //System.out.println("n= "+ n);
			// Traverse all nodes of current level
			for (int i = 1; i <= n; i++) {
				TreeNode temp = queue.poll();
                //System.out.println("i= "+ i);
                //System.out.println("temp= " + temp.val);
				// Print the left most element at
				// the level
				if (i == n)
                {list.add(temp.val);}

				// Add left node to queue
				if (temp.left != null)
					queue.add(temp.left);

				// Add right node to queue
				if (temp.right != null)
					queue.add(temp.right);
			}
        
		}
     return list;   
	}

	


        
    }
