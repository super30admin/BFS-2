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
function rightSideView(root: TreeNode | null): number[] {
	let result = [];
	if (root === null) return result;

	// add root to queue for processing
	let q = [root];

	while (q.length > 0) {
		let size = q.length;

		// process all the nodes at current level
		for (let i = 0; i < size; i++) {
			let element = q.shift();

			// if this is the last element of the current level, add it to the view result
			if (i == size - 1) {
				result.push(element.val);
			}

			if (element.left) {
				q.push(element.left);
			}
			if (element.right) {
				q.push(element.right);
			}
		}
	}

	return result;
}
