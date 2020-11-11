import java.util.LinkedList;
import java.util.Queue;

public class CousinsUsingBFS {
	public boolean isCousins(TreeNode root, int x, int y) {

		Queue<TreeNode> qu = new LinkedList<>();
		qu.add(root);
		while (!qu.isEmpty()) {
			int size = qu.size();
			boolean x_found = false;
			boolean y_found = false;
			for (int i = 0; i < size; i++) {
				TreeNode curr = qu.poll();
				if (curr.val == x)
					x_found = true;

				if (curr.val == y)
					y_found = true;

				if (curr.left != null && curr.right != null) {
					if ((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x))
						return false;

				}

				if (curr.left != null)
					qu.add(curr.left);
				if (curr.right != null)
					qu.add(curr.right);

			}
			if (x_found && y_found)
				return true;
			if (x_found || y_found)
				return false;

		}

		return false;

	}
}
