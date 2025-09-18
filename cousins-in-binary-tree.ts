/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */
// Time complexity - O(n), n = number of nodes in the tree
// Space complexity - O(n)
function isCousins(root: TreeNode | null, x: number, y: number): boolean {
	if (root === null) return false;

	// add root node to queue for processing
	let q = [root];

	while (q.length > 0) {
		const size = q.length;
		let xfound = false;
		let yfound = false;

		// start processing the current node
		for (let i = 0; i < size; i++) {
			const curr = q.shift();

			// return false check if x and y are child or curr node
			if (curr.left !== null && curr.right !== null) {
				if (curr.left.val === x && curr.right.val === y) return false;
				if (curr.left.val === y && curr.right.val === x) return false;
			}

			// mark found x
			if (curr.val === x) {
				xfound = true;
			}
			// mark found y
			if (curr.val === y) {
				yfound = true;
			}

			if (curr.left) {
				q.push(curr.left);
			}
			if (curr.right) {
				q.push(curr.right);
			}
		}

		// if both are found as cousins, return true
		if (xfound && yfound) return true;
	}
	return false;
}
