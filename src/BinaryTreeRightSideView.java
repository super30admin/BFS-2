import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Time Complexity of the algorithm is O(n) where n is no. of nodes.
 * space Complexity will O(n) where n nodes will be in queue.
 */

public class BinaryTreeRightSideView {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();

		if (root == null)
			return result;

		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {

				TreeNode curr = q.poll();

				if (i == size - 1) {
					result.add(curr.val);
				}

				if (curr.left != null)
					q.add(curr.left);

				if (curr.right != null)
					q.add(curr.right);

			}
		}

		return result;
	}

	// DFS right

//    List<Integer> result;

//    public List<Integer> rightSideView(TreeNode root) {

//    result = new ArrayList<>();
//        if(root==null)
//            return result;

//        dfs(root,0);

//        return result;

//    }

//    private void dfs(TreeNode root,int level){

//        //base
//        if(root==null)
//            return;

//        //logic

//        if(level == result.size()){
//            result.add(root.val);
//        }

//        dfs(root.right,level+1);
//        dfs(root.left,level+1);

//    }

	// DFS left

//    public List<Integer> rightSideView(TreeNode root) {

//        result = new ArrayList<>();
//        if(root==null)
//            return result;

//        dfs(root,0);

//        return result;

//    }

//    private void dfs(TreeNode root,int level){

//        //base
//        if(root==null)
//            return;

//        //logic

//        if(level == result.size()){
//            result.add(root.val);
//        }else{
//            result.set(level,root.val);
//        }

//        dfs(root.left,level+1);
//        dfs(root.right,level+1);

//    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTreeRightSideView objIn = new BinaryTreeRightSideView();

	}

}
