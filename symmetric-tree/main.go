package main

// Doing it DFS - looking at my old solution doing DFS made more sense from getgo
// Time  : O(n) - n are the number of nodes
// Space : O(h) - h is height

func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}
	symTree := true
	var dfs func(left *TreeNode, right *TreeNode)
	dfs = func(left *TreeNode, right *TreeNode) {
		// base
		if left == nil && right == nil {
			return
		}
		//if left.Left == nil && right.Right == nil { return }

		// logic
		if left == nil || right == nil || left.Val != right.Val {
			symTree = false
			return
		}

		// condition
		dfs(left.Left, right.Right)
		dfs(left.Right, right.Left)
	}
	dfs(root.Left, root.Right)
	return symTree
}
