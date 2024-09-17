// TC: O(N) since we are traversing every node in the Tree in worst case
// SC: O(H) since we traversing through the recursion till the height of the tree

// Keeping 2 gobal variables for level X and level y and updating as soon as we find our x value which is matching with our root val. we are traversing through the tree using dfs.
//At any point if we come across a condition where our root value  is same for both x and y, we know that they are not cousins, so we return false;
// if we find them at different level and the levels are same, we return true; So we iteratively check for both right and left subtrees for x and y.

public class CousinsBT {

	private int levelX, levelY;
	public boolean cousins(TreeNode root, int x, int y) {
		levelX = 0;
		levelY = 0;
		if(root==null)
			return true;
		return helper(root, 0, x, y) && (levelX==levelY);
	}
	
	public boolean helper(TreeNode root, int level, int x, int y) {
		
		if(root==null)
			return true;
		
		if(root.left!=null && (root.left.val==x || root.left.val==y) && root.right!=null &&(root.right.val==x || root.right.val==y))
			return false;
		
		if(root.val == x)
			levelX = level;
		if(root.val == y)
			levelY = level;
		
		return helper(root.left, level+1, x, y) && helper(root.right, level+1, x, y);
	}
	
	public static void main(String[] args) {
		
		CousinsBT cbt = new CousinsBT();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right =new TreeNode(3);
		root.right.right = new TreeNode(5);
		root.left.right = new TreeNode(4);
		System.out.println(cbt.cousins(root, 4, 5));
	}
	
}
