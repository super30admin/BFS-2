class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<>();
		if(root == null) return result;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int pos = 0;

		while (!queue.isEmpty()) {
			pos = pos == 0 ? 1 : 0;
			int count = queue.size();
			List<Integer> list = new LinkedList<>();
			while (count-- > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
				if (pos == 0) list.add(0, node.val);
				else list.add(node.val);
			}

			result.add(list);
		}

		return result;
	}
}