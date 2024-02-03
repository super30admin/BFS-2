package main

/*time Complexity = O(n)
space Complexity = O(h)*/

func isCousins(root *TreeNode, x int, y int) bool {
	if root == nil {
		return false
	}

	var queue []*TreeNode
	queue = append(queue, root)

	for len(queue) > 0 {
		levelSize := len(queue)

		foundX, foundY := false, false

		for i := 0; i < levelSize; i++ {
			node := queue[0]
			queue = queue[1:]

			if node.Val == x {
				foundX = true
			}
			if node.Val == y {
				foundY = true
			}

			if node.Left != nil && node.Right != nil {
				if (node.Left.Val == x && node.Right.Val == y) || (node.Left.Val == y && node.Right.Val == x) {
					return false
				}
			}

			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}

		if foundX && foundY {
			return true
		} else if foundX || foundY {
			return false
		}
	}

	return false
}
