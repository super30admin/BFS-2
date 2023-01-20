package main

import "fmt"

// Time : O(N) - n are the nodes
// Space : O(h) - h is height
func isCousins(root *TreeNode, x int, y int) bool {
	if root == nil {
		return true
	}
	var dfs func(root *TreeNode, height, x, y int)
	var xParent, yParent *TreeNode
	var xHeight, yHeight int
	dfs = func(root *TreeNode, height int, x int, y int) {
		//base
		if root == nil {
			return
		}

		//logic

		if root.Left != nil && root.Left.Val == x || root.Right != nil && root.Right.Val == x {
			xParent = root
			xHeight = height
		}
		if root.Left != nil && root.Left.Val == y || root.Right != nil && root.Right.Val == y {
			yParent = root
			yHeight = height
			fmt.Println("Parent found", root)
		}
		dfs(root.Left, height+1, x, y)
		dfs(root.Right, height+1, x, y)
	}

	dfs(root, 1, x, y)
	return xParent != yParent && xHeight == yHeight
}
